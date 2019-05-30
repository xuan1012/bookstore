package com.bookstore.bookstore.service.impl;

import com.bookstore.bookstore.dao.model.User;
import com.bookstore.bookstore.dao.UserMapper;
import com.bookstore.bookstore.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bookstore.bookstore.service.info.Regisrelnfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xuan
 * @since 2019-05-30
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    private UserMapper userMapper;


    @Override
    public void add(Regisrelnfo regisrelnfo) {
        User user=new User();
        BeanUtils.copyProperties(regisrelnfo,user);
        userMapper.add1(user);
    }
}
