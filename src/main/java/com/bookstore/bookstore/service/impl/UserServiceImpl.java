package com.bookstore.bookstore.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bookstore.bookstore.dao.UserMapper;
import com.bookstore.bookstore.dao.model.User;
import com.bookstore.bookstore.service.IUserService;
import com.bookstore.bookstore.service.info.Regisrelnfo;
import com.bookstore.bookstore.service.info.SelectUesrInfo;
import com.bookstore.bookstore.web.form.ModifyForm;
import lombok.extern.slf4j.Slf4j;
import org.omg.PortableInterceptor.USER_EXCEPTION;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author xuan
 * @since 2019-05-30
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public void add(Regisrelnfo regisrelnfo) {

        User user = new User();

        BeanUtils.copyProperties(regisrelnfo, user);
        user.setNicname(user.getUsername());
        userMapper.add1(user);
    }

    @Override
    public User select(Regisrelnfo regisrelnfo) {

        User user = new User();

        BeanUtils.copyProperties(regisrelnfo, user);

        User select = userMapper.select(user);

        return select;
    }

    @Override
    public void modify(ModifyForm modifyForm) {

        User user = new User();

        BeanUtils.copyProperties(modifyForm, user);

        userMapper.update(user);

    }

    @Override
    public void modifyPassword(ModifyForm modifyForm) {
        User user = new User();

            BeanUtils.copyProperties(modifyForm, user);

            userMapper.modifyPassword(user);

    }
}
