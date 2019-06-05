package com.bookstore.bookstore.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bookstore.bookstore.dao.model.AllBookMessage;
import com.bookstore.bookstore.service.info.BookInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @program: bookstore
 * @author: xuan
 * @create: 2019-05-29 11:53
 **/
@Mapper
public interface BookMessageMapper{
    IPage<AllBookMessage> findByName(Page page, @Param("bookName") String bookName);
    AllBookMessage findById(@Param("bookId") Long bookId);
    IPage<AllBookMessage> findByAllSearch(Page page,BookInfo bookInfo);
}
