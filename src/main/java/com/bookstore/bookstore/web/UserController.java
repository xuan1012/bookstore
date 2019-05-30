package com.bookstore.bookstore.web;


import com.bookstore.bookstore.dao.model.AllBookMessage;
import com.bookstore.bookstore.dao.model.News;
import com.bookstore.bookstore.dao.model.User;
import com.bookstore.bookstore.service.IUserService;
import com.bookstore.bookstore.service.info.BookInfo;
import com.bookstore.bookstore.service.info.Regisrelnfo;
import com.bookstore.bookstore.web.form.RegisterFrom;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.beans.beancontext.BeanContext;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xuan
 * @since 2019-05-30
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService iUserService;

    @RequestMapping("/reg")
    public String toReg( ModelMap model){

        return "moban/register";
    }


    @RequestMapping("/doReg")
    public String doReg(RegisterFrom registerFrom){
        Regisrelnfo regisrelnfo=new Regisrelnfo();

        BeanUtils.copyProperties(registerFrom,regisrelnfo);

        iUserService.add(regisrelnfo);
        return "store/index";
    }


}
