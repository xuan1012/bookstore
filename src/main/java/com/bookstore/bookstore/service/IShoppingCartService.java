package com.bookstore.bookstore.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bookstore.bookstore.dao.model.AllShops;
import com.bookstore.bookstore.dao.model.Shoppingcart;

import java.util.List;

/**
 * @program: bookstore
 * @author: xuan
 * @create: 2019-05-31 17:13
 **/
public interface IShoppingCartService extends IService<Shoppingcart> {
    List<AllShops> getAllShops(Long userId);

    void addToCart(Long uerId, Long bookId);

    void delCartId(Long cartId);

    void updateCount(Long cartId, Long count);
}
