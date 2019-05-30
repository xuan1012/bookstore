package com.bookstore.bookstore.service;

import com.bookstore.bookstore.dao.model.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bookstore.bookstore.service.info.Regisrelnfo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xuan
 * @since 2019-05-30
 */
public interface IUserService extends IService<User> {

    void add(Regisrelnfo regisrelnfo);
}