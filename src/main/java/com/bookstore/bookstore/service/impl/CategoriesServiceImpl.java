package com.bookstore.bookstore.service.impl;

import com.bookstore.bookstore.dao.model.Categories;
import com.bookstore.bookstore.dao.CategoriesMapper;
import com.bookstore.bookstore.service.ICategoriesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xuan
 * @since 2019-05-29
 */
@Service
public class CategoriesServiceImpl extends ServiceImpl<CategoriesMapper, Categories> implements ICategoriesService {

}
