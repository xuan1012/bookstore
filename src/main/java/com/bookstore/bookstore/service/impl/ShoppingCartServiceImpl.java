package com.bookstore.bookstore.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bookstore.bookstore.dao.*;
import com.bookstore.bookstore.dao.model.AllBookMessage;
import com.bookstore.bookstore.dao.model.AllShops;
import com.bookstore.bookstore.dao.model.Shoppingcart;
import com.bookstore.bookstore.dao.model.Store;
import com.bookstore.bookstore.service.IShoppingCartService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: bookstore
 * @author: xuan
 * @create: 2019-05-31 17:14
 **/
@Service
public class ShoppingCartServiceImpl extends ServiceImpl<ShoppingcartMapper, Shoppingcart> implements IShoppingCartService {
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

    @Override
    public void delCartId(Long cartId) {
        shoppingcartMapper.deleteById(cartId);
    }

    @Override
    public void updateCount(Long cartId, Long count) {
        shoppingcartMapper.updateCount(count, cartId);
    }
}
