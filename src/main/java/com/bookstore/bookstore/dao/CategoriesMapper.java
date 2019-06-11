package com.bookstore.bookstore.dao;

import com.bookstore.bookstore.dao.model.Categories;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author xuan
 * @since 2019-05-29
 */
public interface CategoriesMapper extends BaseMapper<Categories> {
    List<Categories> findByBookId(@Param("bookId") Long bookId);
}
