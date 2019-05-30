package com.bookstore.bookstore.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bookstore.bookstore.dao.model.AllBookMessage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: bookstore
 * @author: xuan
 * @create: 2019-05-29 11:53
 **/
@Mapper
public interface BookMessageMapper{
    List<AllBookMessage> findByName(@Param("bookName") String bookName);
    AllBookMessage findById(@Param("bookId") Long bookId);
}
