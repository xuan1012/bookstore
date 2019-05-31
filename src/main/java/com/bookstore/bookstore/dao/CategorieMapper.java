package com.bookstore.bookstore.dao;

import com.bookstore.bookstore.dao.model.Categorie;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bookstore.bookstore.dao.model.User;

import java.util.List;

/**
 * <p>
 * 分类表 Mapper 接口
 * </p>
 *
 * @author xuan
 * @since 2019-05-31
 */
public interface CategorieMapper extends BaseMapper<Categorie> {

    List select(Categorie categorie);
}
