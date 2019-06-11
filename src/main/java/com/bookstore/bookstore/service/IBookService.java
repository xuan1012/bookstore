package com.bookstore.bookstore.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bookstore.bookstore.dao.model.*;
import com.bookstore.bookstore.service.info.BookInfo;
import org.springframework.ui.ModelMap;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author xuan
 * @since 2019-05-29
 */
public interface IBookService extends IService<Book> {
    List<AllBookMessage> searchByName(String bookName, ModelMap model);
    List<News> findAllNews();
    List<AllBookMessage> findByAllSearch(BookInfo bookInfo, ModelMap model);
    List<AllBookMessage> findBySales(int i, ModelMap model);
    List<AllBookMessage> findNewBooks(ModelMap model);
    AllBookMessage getBookMsg(Long bookId);
}
