package com.bookstore.bookstore.web;


import ch.qos.logback.core.joran.util.beans.BeanUtil;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bookstore.bookstore.dao.UserMapper;
import com.bookstore.bookstore.dao.model.AllBookMessage;
import com.bookstore.bookstore.dao.model.News;
import com.bookstore.bookstore.dao.model.User;
import com.bookstore.bookstore.service.IUserService;
import com.bookstore.bookstore.service.info.BookInfo;
import com.bookstore.bookstore.service.info.Regisrelnfo;
import com.bookstore.bookstore.web.form.RegisterFrom;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.beans.beancontext.BeanContext;
import java.security.PublicKey;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Locale.Category;

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



        Regisrelnfo lnfo=new Regisrelnfo();

        BeanUtils.copyProperties(registerFrom,lnfo);

        iUserService.add(lnfo);

        return "store/login";
    }


    @RequestMapping("/log")
    public String tolog( ModelMap model){

        return "store/login";
    }

    @RequestMapping("/dolog")
    public String log(RegisterFrom registerFrom,ModelMap modelMap){

        Regisrelnfo regisrelnfo=new Regisrelnfo();
        if(registerFrom!=null){

            BeanUtils.copyProperties(registerFrom,regisrelnfo);

            User select = iUserService.select(regisrelnfo);

            if (select==null){
                modelMap.addAttribute("msg","您的账号或者密码错误");
                return "store/login";
            }
        }


        return "store/index";
    }
}
