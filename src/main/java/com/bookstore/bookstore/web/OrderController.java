package com.bookstore.bookstore.web;


import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.bookstore.bookstore.config.AlipayClientParam;
import com.bookstore.bookstore.dao.OrderbuyMapper;
import com.bookstore.bookstore.dao.OrdergroupMapper;
import com.bookstore.bookstore.dao.model.Address;
import com.bookstore.bookstore.dao.model.News;
import com.bookstore.bookstore.dao.model.Orderbuy;
import com.bookstore.bookstore.dao.model.Ordergroup;
import com.bookstore.bookstore.service.IBookService;
import com.bookstore.bookstore.service.IClassificationService;
import com.bookstore.bookstore.service.IOrderService;
import com.bookstore.bookstore.service.info.ClassIficationInfo;
import com.bookstore.bookstore.web.form.OrderForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 订单表 前端控制器
 * </p>
 *
 * @author xuan
 * @since 2019-06-01
 */
@Controller
@RequestMapping("/order")
@Slf4j
public class OrderController {
    @Resource
    IOrderService orderService;
    @Resource
    IBookService bookService;
    @Resource
    OrdergroupMapper ordergroupMapper;
    @Resource
    OrderbuyMapper orderbuyMapper;
    @Resource
    IClassificationService classification;

    @RequestMapping(value = "/subOrder", method = {RequestMethod.POST})
    @ResponseBody
    public Map<String, Object> subOrder(@RequestBody List<OrderForm> orderForms, HttpSession session)
            throws Exception {

        Map<String, Object> map = new HashMap<>(5);
        if (orderForms == null || orderForms.size() <= 0) {
            log.warn("orderForms为空");
            map.put("msg", "false");
            return map;
        }
        List<OrderForm> orderInfos = orderService.initOrder(orderForms);

        session.setAttribute("orderForms", orderInfos);
        map.put("msg", "success");

        return map;
    }

    @RequestMapping("/orderList")
    public String orderList(ModelMap map, HttpSession session,ModelMap model) {
        List<OrderForm> orderForms = (List<OrderForm>) session.getAttribute("orderForms");
        if (session.getAttribute("userId") != null) {
            Long userId = (Long) session.getAttribute("userId");
            List<Address> address = orderService.getAddress(userId);
            map.addAttribute("address", address);
        }
        map.addAttribute("orderForms", orderForms);
        getClassification(model);
        return "order/orderList";
    }

    @RequestMapping(value = "/sub", method = {RequestMethod.POST})
    @ResponseBody
    @Transactional(rollbackFor = Exception.class)
    public Map<String, Object> sub(@RequestBody List<OrderForm> orderForms, HttpSession session)
            throws Exception {
        Map<String, Object> map = new HashMap<>(5);
        if (orderForms == null || orderForms.size() <= 0) {
            log.warn("orderForms为空");
            map.put("msg", "false");
            return map;
        }
        Ordergroup ordergroup = orderService.addOrder(orderForms, session);
        map.put("msg", "success");
        map.put("ordergroup", ordergroup);
        return map;
    }

    /**
     * @Description: 前往支付宝第三方网关进行支付
     */
    @RequestMapping(value = "/goAlipay", produces = "text/html; charset=UTF-8")
    @ResponseBody
    public String goAlipay(String orderId) throws Exception {

        Ordergroup order = ordergroupMapper.selectById(orderId);


        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayClientParam.gatewayUrl, AlipayClientParam.app_id, AlipayClientParam.merchant_private_key, "json", AlipayClientParam.charset, AlipayClientParam.alipay_public_key, AlipayClientParam.sign_type);
        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayClientParam.return_url);
        alipayRequest.setNotifyUrl(AlipayClientParam.notify_url);
        //商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no = orderId;
        //付款金额，必填
        String total_amount = String.valueOf(order.getMoney());
        //订单名称，必填
        String subject = order.getGroupContent();
        //商品描述，可空
//        String body = "用户订购商品个数：" + order.getOrderCount();
        String body = "";
        // 该笔订单允许的最晚付款时间，逾期将关闭交易。取值范围：1m～15d。m-分钟，h-小时，d-天，1c-当天（1c-当天的情况下，无论交易何时创建，都在0点关闭）。 该参数数值不接受小数点， 如 1.5h，可转换为 90m。
        String timeout_express = "1c";
        alipayRequest.setBizContent("{\"out_trade_no\":\"" + out_trade_no + "\","
                + "\"total_amount\":\"" + total_amount + "\","
                + "\"subject\":\"" + subject + "\","
                + "\"body\":\"" + body + "\","
                + "\"timeout_express\":\"" + timeout_express + "\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        //请求
        String result = alipayClient.pageExecute(alipayRequest).getBody();
        return result;
    }

    /**
     * @Description: 支付宝同步通知页面
     */
    @RequestMapping(value = "alipayReturnNotice")
    public ModelAndView alipayReturnNotice(HttpServletRequest request, HttpServletRequest response, HttpSession session) throws Exception {
        log.info("支付成功, 进入同步通知接口...");
        //获取支付宝GET过来反馈信息
        Map<String, String> params = new HashMap<String, String>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用
            valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            params.put(name, valueStr);
        }

        //调用SDK验证签名
        boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayClientParam.alipay_public_key, AlipayClientParam.charset, AlipayClientParam.sign_type);
//        ModelAndView mv = new ModelAndView("alipaySuccess");
        ModelAndView mv = new ModelAndView("/order/orderList");
        //——请在这里编写您的程序（以下代码仅作参考）——
        if (signVerified) {
            //商户订单号
            String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");

            //支付宝交易号
            String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"), "UTF-8");

            //付款金额
            String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"), "UTF-8");

            // 修改订单状态为支付成功，已付款; 同时新增支付流水
            List<Orderbuy> ordersTodo = (List<Orderbuy>) session.getAttribute("ordersTodo");
            for (Orderbuy orderbuy : ordersTodo) {
                orderbuy.setState("已支付");
                orderbuyMapper.updateById(orderbuy);
            }
//            orderService.updateById();
            Ordergroup orderbuy = ordergroupMapper.selectById(out_trade_no);
            log.info("********************** 支付成功(支付宝同步通知) **********************");
            log.info("* 订单号: {}", out_trade_no);
            log.info("* 支付宝交易号: {}", trade_no);
            log.info("* 实付金额: {}", total_amount);
            log.info("* 购买产品: {}", orderbuy.getGroupContent());
            log.info("***************************************************************");
            mv.addObject("out_trade_no", out_trade_no);
            mv.addObject("trade_no", trade_no);
            mv.addObject("total_amount", total_amount);
            mv.addObject("productName", orderbuy.getGroupContent());
        } else {
            log.info("支付, 验签失败...");
        }
        return mv;
    }

    /**
     * @Description: 支付宝异步 通知页面
     */
    @RequestMapping(value = "alipayNotifyNotice")
    @ResponseBody
    public String alipayNotifyNotice(HttpServletRequest request, HttpServletRequest response, HttpSession session) throws Exception {

        log.info("支付成功, 进入异步通知接口...");

        //获取支付宝POST过来反馈信息
        Map<String, String> params = new HashMap<String, String>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用
            /*valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");*/
            params.put(name, valueStr);
        }

        //调用SDK验证签名
        boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayClientParam.alipay_public_key, AlipayClientParam.charset, AlipayClientParam.sign_type);

        //——请在这里编写您的程序（以下代码仅作参考）——

   /* 实际验证过程建议商户务必添加以下校验：
   1、需要验证该通知数据中的out_trade_no是否为商户系统中创建的订单号，
   2、判断total_amount是否确实为该订单的实际金额（即商户订单创建时的金额），
   3、校验通知中的seller_id（或者seller_email) 是否为out_trade_no这笔单据的对应的操作方（有的时候，一个商户可能有多个seller_id/seller_email）
   4、验证app_id是否为该商户本身。
   */
        //验证成功
        if (signVerified) {
            //商户订单号
            String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");

            //支付宝交易号
            String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"), "UTF-8");

            //交易状态
            String trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"), "UTF-8");

            //付款金额
            String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"), "UTF-8");

            if (trade_status.equals("TRADE_FINISHED")) {
                //判断该笔订单是否在商户网站中已经做过处理
                //如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
                //如果有做过处理，不执行商户的业务程序

                //注意： 尚自习的订单没有退款功能, 这个条件判断是进不来的, 所以此处不必写代码
                //退款日期超过可退款期限后（如三个月可退款），支付宝系统发送该交易状态通知
            } else if (trade_status.equals("TRADE_SUCCESS")) {
                //判断该笔订单是否在商户网站中已经做过处理
                //如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
                //如果有做过处理，不执行商户的业务程序

                //注意：
                //付款完成后，支付宝系统发送该交易状态通知

                // 修改叮当状态，改为 支付成功，已付款; 同时新增支付流水
//                orderService.updateOrderStatus(out_trade_no, trade_no, total_amount);
                List<Orderbuy> ordersTodo = (List<Orderbuy>) session.getAttribute("ordersTodo");
                for (Orderbuy orderbuy : ordersTodo) {
                    orderbuy.setState("已支付");
                    orderbuyMapper.updateById(orderbuy);
                }

                Ordergroup orderbuy = ordergroupMapper.selectById(out_trade_no);

                log.info("********************** 支付成功(支付宝异步通知) **********************");
                log.info("* 订单号: {}", out_trade_no);
                log.info("* 支付宝交易号: {}", trade_no);
                log.info("* 实付金额: {}", total_amount);
                log.info("* 购买产品: {}", orderbuy.getGroupContent());
                log.info("***************************************************************");
            }
            log.info("支付成功...");
        } else {//验证失败
            log.info("支付, 验签失败...");
        }
        return "success";
    }

    public void getClassification(ModelMap model) {
        List<ClassIficationInfo> categories = classification.classification();
        model.addAttribute("categories", categories);


        List<News> news = bookService.findAllNews();

        model.addAttribute("news", news);
    }
}
