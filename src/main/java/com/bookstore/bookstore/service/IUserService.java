package com.bookstore.bookstore.service;

import com.bookstore.bookstore.dao.model.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bookstore.bookstore.service.info.Regisrelnfo;
import com.bookstore.bookstore.web.form.ModifyForm;
import com.bookstore.bookstore.web.form.RegisterFrom;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author xuan
 * @since 2019-05-30
 */
public interface IUserService extends IService<User> {

    void add(Regisrelnfo regisrelnfo);

    User select(Regisrelnfo regisrelnfo);

    void modify(ModifyForm modifyForm);

    void modifyPassword(ModifyForm modifyForm);

    User getBack(ModifyForm modifyForm);

    User selectName(RegisterFrom registerFrom);

    void getPW(ModifyForm modifyForm);
}
