package com.bookstore.bookstore.web;


import com.bookstore.bookstore.dao.model.AllBookMessage;
import com.bookstore.bookstore.dao.model.News;
import com.bookstore.bookstore.service.IBookService;
import com.bookstore.bookstore.service.IClassificationService;
import com.bookstore.bookstore.service.info.BookInfo;
import com.bookstore.bookstore.service.info.ClassIficationInfo;
import com.bookstore.bookstore.web.form.BookForm;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
@Slf4j
public class BookController {
    private static Logger logger = LoggerFactory.getLogger(BookController.class);
    @Resource
    IBookService bookService;
    @Resource
    IClassificationService classification;


    @RequestMapping("/search")
    public String searchByname(String bookName, ModelMap model, RedirectAttributes attr) {
        attr.addAttribute("bookName", bookName);
        return "redirect:/book/findBook";
    }

    @RequestMapping("/findBook")
    public String findBookByName(String bookName, ModelMap model) {
        getBooksAndNews(bookName, model);
        getClassification(model);
        return "store/shop";
    }

    @RequestMapping("/allSearch")
    public String getByAll(BookForm bookForm, ModelMap model) {
        BookInfo bookInfo = new BookInfo();
        if (bookForm.getPage() == null) {
            bookForm.setPage(1L);
        }
        BeanUtils.copyProperties(bookForm, bookInfo);
        List<AllBookMessage> byAllSearch = bookService.findByAllSearch(bookInfo, model);
        model.addAttribute("books", byAllSearch);
        model.addAttribute("bookForm", bookForm);
        model.addAttribute("bookName", bookForm.getBookName());
        getClassification(model);
        return "store/shop";
    }


    private void getBooksAndNews(String bookName, ModelMap model) {
        if (bookName == null) {
            bookName = "";
        }
        List<AllBookMessage> books = bookService.searchByName(bookName.trim(), model);
        model.addAttribute("books", books);
        model.addAttribute("bookName", bookName.trim());
        getNews(model);
    }

    private void getNews(ModelMap model) {
        List<News> news = bookService.findAllNews();
        model.addAttribute("news", news);
    }

    public void getClassification(ModelMap model) {
        List<ClassIficationInfo> categories = classification.classification();
        model.addAttribute("categories", categories);
        List<News> news = bookService.findAllNews();
        model.addAttribute("news", news);
    }


}
