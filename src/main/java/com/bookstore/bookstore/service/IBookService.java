package com.bookstore.bookstore.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bookstore.bookstore.dao.model.*;

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
    List<AllShops> getAllShops(Long userId);
}
