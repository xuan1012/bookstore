package com.bookstore.bookstore.dao;

import com.bookstore.bookstore.dao.model.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xuan
 * @since 2019-05-30
 */
public interface UserMapper extends BaseMapper<User> {

    void add1(User user);

    User select(User user);

    void update(User user);

    void modifyPassword(User user);

    User getUser(User user);

    User selectName(User user);

    void setPW(User user);

}
