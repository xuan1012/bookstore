package com.bookstore.bookstore.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bookstore.bookstore.dao.*;
import com.bookstore.bookstore.dao.model.*;
import com.bookstore.bookstore.service.IBookService;
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
    BookMessageMapper bookMessageMapper;
    @Resource
    PicturesMapper picturesMapper;
    @Resource
    CategoriesMapper categoriesMapper;
    @Resource
    NewsMapper newsMapper;
    @Resource
    ShoppingcartMapper shoppingcartMapper;
    @Resource
    StoreMapper storeMapper;

    @Override
    public List<AllBookMessage> searchByName(String bookName) {

        List<AllBookMessage> books = bookMessageMapper.findByName(bookName);
        for (AllBookMessage book : books) {
            Long bookId = book.getBookId();
            book.setPictureContent(picturesMapper.getBookPicture(bookId));
            book.setCategories(categoriesMapper.findByBookId(bookId));
        }

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
    public List<AllShops> getAllShops(Long userId) {
        List<AllShops> shops = shoppingcartMapper.findByUser(userId);
        for (AllShops shop : shops) {
            Long bookId = shop.getBookId();
            AllBookMessage book = bookMessageMapper.findById(bookId);
            Store store = storeMapper.selectById(book.getStoreId());
            shop.setPictureContent(picturesMapper.getBookPicture(bookId));
            shop.setAuthor(book.getAuthor());
            shop.setBookPrice(book.getBookPrice());
            shop.setBookName(book.getBookName());
            shop.setSellStore(store.getStoreName());
        }
        return shops;
    }

    @Override
    public void addToCart(Long uerId, Long bookId) {
        AllShops byBookId = shoppingcartMapper.findByBookId(bookId, uerId);
        if (byBookId == null) {
            shoppingcartMapper.addToCart(uerId, bookId);
        } else {
            Long count = byBookId.getCount() + 1;
            Long cartId = byBookId.getCartId();
            shoppingcartMapper.updateCount(count, cartId);
        }
    }


}
