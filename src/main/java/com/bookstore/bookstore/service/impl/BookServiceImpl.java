package com.bookstore.bookstore.service.impl;

import com.bookstore.bookstore.dao.model.Book;
import com.bookstore.bookstore.dao.BookMapper;
import com.bookstore.bookstore.service.IBookService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xuan
 * @since 2019-05-29
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements IBookService {

}
