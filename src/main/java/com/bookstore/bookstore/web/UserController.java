package com.bookstore.bookstore.web;


import com.bookstore.bookstore.dao.model.News;
import com.bookstore.bookstore.dao.model.User;
import com.bookstore.bookstore.service.IBookService;
import com.bookstore.bookstore.service.IClassificationService;
import com.bookstore.bookstore.service.IUserService;
import com.bookstore.bookstore.service.info.ClassIficationInfo;
import com.bookstore.bookstore.service.info.Regisrelnfo;
import com.bookstore.bookstore.web.form.ModifyForm;
import com.bookstore.bookstore.web.form.RegisterFrom;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
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
    @Autowired
    private IClassificationService classification;
    @Resource
    IBookService bookService;

    @RequestMapping("/reg")
    public String toReg(ModelMap model) {
        getClassification(model);
        return "store/register";
    }

    @RequestMapping("/doReg")
    public String doReg(RegisterFrom registerFrom, ModelMap map) {
        Regisrelnfo lnfo = new Regisrelnfo();
        BeanUtils.copyProperties(registerFrom, lnfo);
        iUserService.add(lnfo);
        map.addAttribute("msg", "注册成功！请登录");
        getClassification(map);
        return "store/login";
    }

    @RequestMapping("/log")
    public String tolog(ModelMap model) {
        getClassification(model);
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
        getClassification(modelMap);
        return "redirect:/";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();

        return "redirect:/";
    }

    public void getClassification(ModelMap model) {
        List<ClassIficationInfo> categories = classification.classification();
        model.addAttribute("categories", categories);


        List<News> news = bookService.findAllNews();

        model.addAttribute("news", news);
    }

    //个人信息
    @RequestMapping("/information")
    public String information(ModelMap modelMap, HttpSession session) {

        Long userId = (Long) session.getAttribute("userId");

        User user = iUserService.getById(userId);

        modelMap.addAttribute("use", user);


        return "moban/information";
    }

    //信息修改
    @RequestMapping("/modify")
    public String modify(HttpSession session, ModifyForm modifyForm, ModelMap model) {

        Long userId = (Long) session.getAttribute("userId");

        if (userId != null) {

            iUserService.modify(modifyForm);

        }

        return "redirect:/user/information";
    }

    //修改密码
    @RequestMapping("/to")
    public String toModify() {

        return "store/modifyPassword";
    }

    @RequestMapping("/modifyPassword")
    public String modifyPassword(HttpSession session, ModifyForm modifyForm, ModelMap model) {

        Long userId = (Long) session.getAttribute("userId");

        modifyForm.setUserId(userId);

        iUserService.modifyPassword(modifyForm);

        return "redirect:/user/information";
    }

}
