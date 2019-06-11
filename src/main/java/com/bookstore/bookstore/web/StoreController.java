package com.bookstore.bookstore.web;


import com.bookstore.bookstore.dao.model.AllBookMessage;
import com.bookstore.bookstore.service.IBookService;
import com.bookstore.bookstore.service.ICommentService;
import com.bookstore.bookstore.service.info.CommentInfo;
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
@RequestMapping("/store")
public class StoreController {
    @Resource
    IBookService bookService;
    @Resource
    ICommentService commentService;

    @RequestMapping("/query")
    public String shopDetail(Long bookId, ModelMap map) {
        AllBookMessage book = bookService.getBookMsg(bookId);
        List<CommentInfo> comments = commentService.getComment(bookId, map);
        map.addAttribute("book", book);
        map.addAttribute("comments", comments);
        return "store/shopdetail";
    }

}
