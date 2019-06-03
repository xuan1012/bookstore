package com.bookstore.bookstore.web;


import com.bookstore.bookstore.dao.model.Address;
import com.bookstore.bookstore.service.IOrderService;
import com.bookstore.bookstore.web.form.OrderForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
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
        System.out.println(orderForms);
        return map;
    }

    @RequestMapping("/orderList")
    public String orderList(ModelMap map, HttpSession session) {
        List<OrderForm> orderForms = (List<OrderForm>) session.getAttribute("orderForms");
        if (session.getAttribute("userId") != null) {
            Long userId = (Long) session.getAttribute("userId");
            List<Address> address = orderService.getAddress(userId);
            map.addAttribute("address", address);
        }
        map.addAttribute("orderForms", orderForms);

        return "order/orderList";
    }

    @RequestMapping(value = "/sub", method = {RequestMethod.POST})
    @ResponseBody
    public Map<String, Object> sub(@RequestBody List<OrderForm> orderForms, HttpSession session)
            throws Exception {

        return null;
    }

}
