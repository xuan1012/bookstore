package com.bookstore.bookstore.service.impl;

import com.bookstore.bookstore.dao.model.Categorie;
import com.bookstore.bookstore.dao.CategorieMapper;
import com.bookstore.bookstore.service.ICategorieService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bookstore.bookstore.service.info.CategoieInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.Action;
import java.util.List;

/**
 * <p>
 * 分类表 服务实现类
 * </p>
 *
 * @author xuan
 * @since 2019-05-31
 */
@Service
public class CategorieServiceImpl extends ServiceImpl<CategorieMapper, Categorie> implements ICategorieService {

    @Autowired
    private CategorieMapper categorieMapper;


    @Override
    public List<Categorie> get() {
        return null;
    }
}
