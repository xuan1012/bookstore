package com.bookstore.bookstore.dao;

import com.bookstore.bookstore.dao.model.Store;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author xuan
 * @since 2019-05-29
 */
public interface StoreMapper extends BaseMapper<Store> {
    Store findByName(@Param("name") String sellStore);
}
