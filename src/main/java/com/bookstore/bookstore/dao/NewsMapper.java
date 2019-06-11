package com.bookstore.bookstore.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bookstore.bookstore.dao.model.News;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author xuan
 * @since 2019-05-29
 */
public interface NewsMapper extends BaseMapper<News> {
    IPage<News> findAll(Page page);
}
