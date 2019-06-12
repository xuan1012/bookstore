package com.bookstore.bookstore.web;

import com.bookstore.bookstore.dao.model.AllBookMessage;
import com.bookstore.bookstore.dao.model.News;
import com.bookstore.bookstore.service.IBookService;
import com.bookstore.bookstore.service.ICategoriesService;
import com.bookstore.bookstore.service.IClassificationService;
import com.bookstore.bookstore.service.info.BookInfo;
import com.bookstore.bookstore.service.info.ClassIficationInfo;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private IClassificationService classification;

    @Autowired
    private ICategoriesService categoriesService;

    @RequestMapping("/hello")
    @ResponseBody
    public Map hello() {
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "hello");
        return map;
    }
    
    /** 
    * @Description: 主页展示 描述
    * @Param: [model] 参数
    * @return: java.lang.String 
    * @Author: xuan 
    * @Date: 2019/6/12 
    */ 
    @RequestMapping("/")
    public String index(ModelMap model) {
        BookInfo storyBookInfo = getBookInfo("小说");
        BookInfo studyBookInfo = getBookInfo("学习");
        List<News> news = bookService.findAllNews();
        List<ClassIficationInfo> categories = classification.classification();
        List<AllBookMessage> bySales = bookService.findBySales(1, model);
        List<AllBookMessage> bySales2 = bookService.findBySales(2, model);
        List<AllBookMessage> newBooks = bookService.findNewBooks(model);
        List<AllBookMessage> storyBooks = bookService.findByAllSearch(storyBookInfo, model);
        List<AllBookMessage> studyBooks = bookService.findByAllSearch(studyBookInfo, model);
        model.addAttribute("news", news);
        model.addAttribute("books", bySales);
        model.addAttribute("books2", bySales2);
        model.addAttribute("newBooks", newBooks);
        model.addAttribute("categories", categories);
        model.addAttribute("storyBooks", storyBooks);
        model.addAttribute("studyBooks", studyBooks);
        return "store/index";
    }

    public BookInfo getBookInfo(String type) {
        BookInfo bookInfo = new BookInfo();
        bookInfo.setSales("销量降序↓");
        bookInfo.setClassname(type);
        bookInfo.setPage(1L);
        return bookInfo;
    }


}
