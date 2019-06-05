package com.bookstore.bookstore.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bookstore.bookstore.dao.*;
import com.bookstore.bookstore.dao.model.AllBookMessage;
import com.bookstore.bookstore.dao.model.Book;
import com.bookstore.bookstore.dao.model.News;
import com.bookstore.bookstore.dao.model.Pages;
import com.bookstore.bookstore.service.IBookService;
import com.bookstore.bookstore.service.info.BookInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

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
@Slf4j
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements IBookService {
    @Resource
    BookMessageMapper bookMessageMapper;
    @Resource
    PicturesMapper picturesMapper;
    @Resource
    CategoriesMapper categoriesMapper;
    @Resource
    NewsMapper newsMapper;


    @Override
    public List<AllBookMessage> searchByName(String bookName, ModelMap model) {
        Page<AllBookMessage> page = new Page<>(1, 9);
        IPage<AllBookMessage> bookPage = bookMessageMapper.findByName(page, bookName);
        List<AllBookMessage> books = getAllBookMessages(model, bookPage);
        return books;
    }


    @Override
    public List<News> findAllNews() {
        List<News> news = newsMapper.findAll();
        for (News news1 : news) {
            AllBookMessage book = bookMessageMapper.findById(news1.getNewsId());
            news1.setPrice(book.getBookPrice());
        }
        return news;
    }

    @Override
    public List<AllBookMessage> findByAllSearch(BookInfo bookInfo, ModelMap model) {

        Page<AllBookMessage> page = new Page<>(bookInfo.getPage(), 9);
        IPage<AllBookMessage> bookPage = bookMessageMapper.findByAllSearch(page, bookInfo);
        List<AllBookMessage> allSearch = getAllBookMessages(model, bookPage);
        return allSearch;
    }

    public List<AllBookMessage> getAllBookMessages(ModelMap model, IPage<AllBookMessage> bookPage) {
        List<AllBookMessage> books = bookPage.getRecords();
        for (AllBookMessage book : books) {
            Long bookId = book.getBookId();
            book.setPictureContent(picturesMapper.getBookPicture(bookId));
            book.setCategories(categoriesMapper.findByBookId(bookId));
        }
        Pages pages = new Pages();
        pages.setPages(bookPage.getPages());
        pages.setTotal(bookPage.getTotal());
        pages.setCurrent(bookPage.getCurrent());

        model.addAttribute("bookPage", pages);
        return books;
    }
}
