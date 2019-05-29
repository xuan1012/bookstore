package com.bookstore.bookstore.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bookstore.bookstore.dao.model.AllBookMessage;
import com.bookstore.bookstore.dao.model.Book;
import com.bookstore.bookstore.dao.model.News;

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
    List<AllBookMessage> searchByName(String bookName);
    List<News> findAllNews();
}
