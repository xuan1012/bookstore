package com.bookstore.bookstore.web;

import com.bookstore.bookstore.dao.model.News;
import com.bookstore.bookstore.service.IBookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: bookstore
 * @author: xuan
 * @create: 2019-05-24 21:16
 **/
@Controller
public class HelloController {

    @Resource
    IBookService bookService;

    @RequestMapping("/hello")
    @ResponseBody
    public Map hello() {
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "hello");
        return map;
    }

    @RequestMapping("/")
    public String index(ModelMap model) {
        List<News> news = bookService.findAllNews();
        model.addAttribute("news", news);
        return "store/index";
    }

    //改了
}
