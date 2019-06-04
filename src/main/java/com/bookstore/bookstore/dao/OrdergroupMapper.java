package com.bookstore.bookstore.dao;

import com.bookstore.bookstore.dao.model.Ordergroup;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xuan
 * @since 2019-06-04
 */
public interface OrdergroupMapper extends BaseMapper<Ordergroup> {
    Ordergroup findMaxId();
}
