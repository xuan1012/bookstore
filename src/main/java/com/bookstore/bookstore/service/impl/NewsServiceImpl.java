package com.bookstore.bookstore.service.impl;

import com.bookstore.bookstore.dao.model.News;
import com.bookstore.bookstore.dao.NewsMapper;
import com.bookstore.bookstore.service.INewsService;
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
public class NewsServiceImpl extends ServiceImpl<NewsMapper, News> implements INewsService {

}
