package com.bookstore.bookstore.service;

import com.bookstore.bookstore.dao.model.Categorie;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bookstore.bookstore.service.info.CategoieInfo;
import org.hibernate.validator.constraints.EAN;

import java.util.List;

/**
 * <p>
 * 分类表 服务类
 * </p>
 *
 * @author xuan
 * @since 2019-05-31
 */
public interface ICategorieService extends IService<Categorie> {

    List<Categorie> get();
}
