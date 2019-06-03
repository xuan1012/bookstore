package com.bookstore.bookstore.web;


import com.bookstore.bookstore.web.form.OrderForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;

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
public class OrderController {

    @RequestMapping(value = "/subOrder", method = {RequestMethod.POST})
    @ResponseBody
    public String subOrder(@RequestBody List<OrderForm> orderForms)
            throws Exception {
        String result = "";
        if (orderForms == null || orderForms.size() <= 0) {
            return "No any ID.中文";
        }
//        for (OrderForm orderForm : orderForms) {
//            orderForm.setOrderDate(LocalDateTime.now());
//
//        }
        Iterator it = orderForms.iterator();
        while (it.hasNext()) {
            OrderForm next = (OrderForm) it.next();
            next.setOrderDate(LocalDateTime.now());
            next.setOrderPrice((next.getOnePrice()).multiply(new BigDecimal(next.getOrderCount())));
            if ("f".equals(next.getUserAddress())) {
                it.remove();
            }
        }

        System.out.println(orderForms);
        return result;
    }

}
