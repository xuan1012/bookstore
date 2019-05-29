package com.bookstore.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: bookstore
 * @author: xuan
 * @create: 2019-05-24 21:16
 **/
@Controller
public class HelloController {
    @RequestMapping("/hello")
    @ResponseBody
    public Map hello() {
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "hello");
        return map;
    }

//    @RequestMapping("/")
//    public String test() {
//        return "store/index";
//    }

    @RequestMapping("/")
    public String shoppingCart() {
        return "store/index";
    }
}
