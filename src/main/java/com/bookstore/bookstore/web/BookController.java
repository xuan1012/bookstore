package com.bookstore.bookstore.web;


import com.bookstore.bookstore.dao.model.AllBookMessage;
import com.bookstore.bookstore.dao.model.AllShops;
import com.bookstore.bookstore.dao.model.News;
import com.bookstore.bookstore.service.IBookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
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
    public String searchByname(String bookName, ModelMap model, RedirectAttributes attr) {
        attr.addAttribute("bookName", bookName);
        return "redirect:/book/findBook";
    }

    @RequestMapping("findBook")
    public String findBook(String bookName, ModelMap model) {
        getBooksAndNews(bookName, model);
        return "store/shop";
    }

    private void getBooksAndNews(String bookName, ModelMap model) {
        if (bookName == null) {
            bookName = "";
        }
        List<AllBookMessage> books = bookService.searchByName(bookName.trim());
        List<News> news = bookService.findAllNews();
        model.addAttribute("books", books);
        model.addAttribute("bookName", bookName.trim());
        model.addAttribute("news", news);
    }

    @RequestMapping("cart")
    public String shoppingCart(HttpSession session, ModelMap map) {

        if (session.getAttribute("userId") != null) {
            Long userId = (Long) session.getAttribute("userId");
            getCartShops(userId, map);
            return "store/cart";
        }
        map.addAttribute("msg", "没有商品哦");
        map.addAttribute("shops", null);

        return "store/cart";
    }

    private void getCartShops(Long userId, ModelMap map) {
        List<AllShops> allShops = bookService.getAllShops(userId);
        map.addAttribute("shops", allShops);
    }
}
