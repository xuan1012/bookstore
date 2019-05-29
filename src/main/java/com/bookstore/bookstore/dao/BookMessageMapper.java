package com.bookstore.bookstore.dao;

import com.bookstore.bookstore.dao.model.AllBookMessage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @program: bookstore
 * @author: xuan
 * @create: 2019-05-29 11:53
 **/
@Mapper
public interface BookMessageMapper {
    List<AllBookMessage> findByName(String bookName);
}
