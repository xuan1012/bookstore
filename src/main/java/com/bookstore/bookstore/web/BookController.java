package com.bookstore.bookstore.web;


import com.bookstore.bookstore.dao.model.AllBookMessage;
import com.bookstore.bookstore.dao.model.News;
import com.bookstore.bookstore.service.IBookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author xuan
 * @since 2019-05-29
 */
@Controller
@RequestMapping("/book")
public class BookController {
    private static Logger logger = LoggerFactory.getLogger(BookController.class);
    @Resource
    IBookService bookService;


    @RequestMapping("search")
    public String searchByname(String bookName, ModelMap model){
        List<AllBookMessage> books = bookService.searchByName(bookName.trim());
        List<News> news = bookService.findAllNews();
        model.addAttribute("books",books);
        model.addAttribute("news",news);
        return "store/shop";
    }
}
