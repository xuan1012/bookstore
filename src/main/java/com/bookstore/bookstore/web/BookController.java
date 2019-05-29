package com.bookstore.bookstore.web;


import com.bookstore.bookstore.dao.model.Book;
import com.bookstore.bookstore.service.IBookService;
import com.bookstore.bookstore.service.info.BookInfo;
import com.bookstore.bookstore.web.form.BookForm;
import org.springframework.beans.BeanUtils;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@RestController
@RequestMapping("/book")
public class BookController {
    @Resource
    IBookService bookService;
    @RequestMapping("search")
    public String searchByname(BookForm form, Model model){
        BookInfo bookInfo = new BookInfo();
        BeanUtils.copyProperties(form, bookInfo);
        List<Book> books = bookService.searchByName(bookInfo);
        model.addAttribute("books",books);
        return "store/shop";
    }
}
