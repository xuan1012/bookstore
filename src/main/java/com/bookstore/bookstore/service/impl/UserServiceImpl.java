package com.bookstore.bookstore.service.impl;

import com.bookstore.bookstore.dao.model.User;
import com.bookstore.bookstore.dao.UserMapper;
import com.bookstore.bookstore.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xuan
 * @since 2019-05-25
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
