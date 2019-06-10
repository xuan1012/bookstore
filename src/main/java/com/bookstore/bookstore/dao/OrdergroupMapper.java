package com.bookstore.bookstore.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bookstore.bookstore.dao.model.Ordergroup;
import com.bookstore.bookstore.service.info.OrdergroupInfo;

import java.util.List;

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
    List<OrdergroupInfo> findAll();
}
