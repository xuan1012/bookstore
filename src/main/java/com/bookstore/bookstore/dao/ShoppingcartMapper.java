package com.bookstore.bookstore.dao;

import com.bookstore.bookstore.dao.model.AllShops;
import com.bookstore.bookstore.dao.model.Shoppingcart;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xuan
 * @since 2019-05-30
 */
public interface ShoppingcartMapper extends BaseMapper<Shoppingcart> {
    List<AllShops> findByUser(@Param("userId") Long userId);
}
