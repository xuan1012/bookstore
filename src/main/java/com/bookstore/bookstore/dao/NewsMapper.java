package com.bookstore.bookstore.dao;

import com.bookstore.bookstore.dao.model.News;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xuan
 * @since 2019-05-29
 */
public interface NewsMapper extends BaseMapper<News> {
    List<News> findAll();
}
