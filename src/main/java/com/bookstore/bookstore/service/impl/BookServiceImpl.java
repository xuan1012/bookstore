package com.bookstore.bookstore.service.impl;

import com.bookstore.bookstore.dao.model.Book;
import com.bookstore.bookstore.dao.BookMapper;
import com.bookstore.bookstore.service.IBookService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bookstore.bookstore.service.info.BookInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author xuan
 * @since 2019-05-29
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements IBookService {
    @Resource
    BookMapper bookMapper;

    @Override
    public List<Book> searchByName(BookInfo bookInfo) {
        Book book = new Book();
        BeanUtils.copyProperties(bookInfo, book);
        return null;
    }
}
