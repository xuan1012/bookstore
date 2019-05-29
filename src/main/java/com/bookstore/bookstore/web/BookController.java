package com.bookstore.bookstore.web;


import com.bookstore.bookstore.dao.PictureMapper;
import com.bookstore.bookstore.dao.model.Book;
import com.bookstore.bookstore.dao.model.Picture;
import com.bookstore.bookstore.service.IBookService;
import com.bookstore.bookstore.service.info.BookInfo;
import com.bookstore.bookstore.web.form.BookForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
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
    @Resource
    PictureMapper pictureMapper;
    @RequestMapping("search")
    public String searchByname(BookForm form, ModelMap model){
        BookInfo bookInfo = new BookInfo();
        BeanUtils.copyProperties(form, bookInfo);
        List<Book> books = bookService.searchByName(bookInfo);
        logger.info("书列表",books);
        Picture picture = pictureMapper.selectById(1);
        model.addAttribute("books",books);
        model.addAttribute("picture",picture);
        return "store/shop";
    }
}
