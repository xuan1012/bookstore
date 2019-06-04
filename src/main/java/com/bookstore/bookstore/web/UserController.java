package com.bookstore.bookstore.web;


import com.bookstore.bookstore.dao.model.User;
import com.bookstore.bookstore.service.IUserService;
import com.bookstore.bookstore.service.info.Regisrelnfo;
import com.bookstore.bookstore.service.info.SelectUesrInfo;
import com.bookstore.bookstore.web.form.ModifyForm;
import com.bookstore.bookstore.web.form.RegisterFrom;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author xuan
 * @since 2019-05-30
 */
@Controller
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private IUserService iUserService;

    @RequestMapping("/reg")
    public String toReg(ModelMap model) {
        return "store/register";
    }

    @RequestMapping("/doReg")
    public String doReg(RegisterFrom registerFrom, ModelMap map) {
        Regisrelnfo lnfo = new Regisrelnfo();
        BeanUtils.copyProperties(registerFrom, lnfo);
        iUserService.add(lnfo);
        map.addAttribute("msg", "注册成功！请登录");
        return "store/login";
    }

    @RequestMapping("/log")
    public String tolog(ModelMap model) {
        return "store/login";
    }

    @RequestMapping("/dolog")
    public String log(RegisterFrom registerFrom, ModelMap modelMap, HttpSession session) {
        Regisrelnfo regisrelnfo = new Regisrelnfo();
        if (registerFrom != null) {
            BeanUtils.copyProperties(registerFrom, regisrelnfo);
            User select = iUserService.select(regisrelnfo);
            if (select == null) {
                modelMap.addAttribute("msg", "您的账号或者密码错误");
                return "store/login";
            }
            session.setAttribute("userId", select.getUserId());
            session.setAttribute("username", registerFrom.getUsername());
        }
        return "store/index";
    }


    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "store/index";
    }

    //个人信息
    @RequestMapping("/information")
    public String information(ModelMap modelMap, HttpSession session) {

        Long userId = (Long) session.getAttribute("userId");

        User user = iUserService.getById(userId);

        modelMap.addAttribute("use", user);

        log.info("用户{}", userId);

        log.info("用户信息{}", user);

        return "moban/information";
    }

    //信息修改
    @RequestMapping("/modify")
    public String modify(ModelMap modelMap, HttpSession session, ModifyForm modifyForm) {

        Long userId = (Long) session.getAttribute("userId");

        if (userId != null) {

            iUserService.modify(modifyForm);

        }

        log.info("用户{}", userId);

        log.info("三大{}", modifyForm);


        return "redirect:/user/information";
    }
}
