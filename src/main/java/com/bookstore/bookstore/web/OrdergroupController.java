package com.bookstore.bookstore.web;


import com.bookstore.bookstore.service.IOrderService;
import com.bookstore.bookstore.service.info.OrdergroupInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author xuan
 * @since 2019-06-04
 */
@Controller
@RequestMapping("/ordergroup")
public class OrdergroupController {
    @Resource
    IOrderService orderService;
    /** 
    * @Description: 管理订单页面的展示 描述
    * @Param: [map, session] 参数
    * @return: java.lang.String 
    * @Author: xuan 
    * @Date: 2019/6/12 
    */ 
    @RequestMapping("/order")
    public String getAllOrder(ModelMap map, HttpSession session) {

        if (session.getAttribute("userId") != null) {
            Long userId = (Long) session.getAttribute("userId");
            List<OrdergroupInfo> allOrder = orderService.getAllOrder(map, userId);
            if (allOrder.size() == 0) {
                map.addAttribute("msg", "您还没有订单哦");
            }
            map.addAttribute("allOrder", allOrder);
        }
        return "store/orderControl";
    }
    
    /** 
    * @Description: 管理订单页面的取消订单 描述
    * @Param: [orderId, session] 参数
    * @return: java.util.Map<java.lang.String,java.lang.Object> 
    * @Author: xuan 
    * @Date: 2019/6/12 
    */ 
    @RequestMapping("/reBuy")
    @ResponseBody
    public Map<String, Object> reBuy(Long orderId, HttpSession session) {
        Map<String, Object> map = new HashMap<>(5);
        orderService.reBuy(orderId);
        map.put("success", true);
        return map;
    }
    /** 
    * @Description: 删除订单 描述
    * @Param: [orderId, session] 参数
    * @return: java.util.Map<java.lang.String,java.lang.Object> 
    * @Author: xuan 
    * @Date: 2019/6/12 
    */ 
    @RequestMapping("/delOrder")
    @ResponseBody
    public Map<String, Object> delOrder(Long orderId, HttpSession session) {
        Map<String, Object> map = new HashMap<>(5);
        orderService.delOrder(orderId);
        map.put("success", true);
        return map;
    }
    /** 
    * @Description: 确认收货 描述
    * @Param: [orderId, session] 参数
    * @return: java.util.Map<java.lang.String,java.lang.Object> 
    * @Author: xuan 
    * @Date: 2019/6/12 
    */ 
    @RequestMapping("/getShop")
    @ResponseBody
    public Map<String, Object> getShop(Long orderId, HttpSession session) {
        Map<String, Object> map = new HashMap<>(5);
        orderService.getShop(orderId);
        map.put("success", true);
        return map;
    }
}
