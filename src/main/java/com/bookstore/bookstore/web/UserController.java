package com.bookstore.bookstore.web;


import com.bookstore.bookstore.dao.model.News;
import com.bookstore.bookstore.dao.model.User;
import com.bookstore.bookstore.service.IBookService;
import com.bookstore.bookstore.service.IClassificationService;
import com.bookstore.bookstore.service.IUserService;
import com.bookstore.bookstore.service.info.ClassIficationInfo;
import com.bookstore.bookstore.service.info.Regisrelnfo;
import com.bookstore.bookstore.service.uit.MailUtil;
import com.bookstore.bookstore.web.form.ModifyForm;
import com.bookstore.bookstore.web.form.RegisterFrom;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
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
        log.info("123 {}", lnfo);
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
    public String log(RegisterFrom registerFrom, ModelMap modelMap, HttpSession session, HttpServletRequest request) {
        Regisrelnfo regisrelnfo = new Regisrelnfo();
        String message;
        UsernamePasswordToken token = new UsernamePasswordToken(registerFrom.getUsername(), registerFrom.getPassword());
        token.setRememberMe(false);
        Subject currUser = SecurityUtils.getSubject();
        try {
            currUser.login(token);

            SavedRequest req = WebUtils.getAndClearSavedRequest(request);
            if (req == null) {
                return "redirect:/";
            } else {
                String requestUrl = req.getRequestUrl();
                return "redirect:" + requestUrl;
            }
        } catch (IncorrectCredentialsException e) {
            log.info("用户名或者密码错误");
            message = "用户名或者密码错误";
        } catch (AuthenticationException e) {
            log.warn("登录失败", e);
            message = "登录失败";
        }
        modelMap.addAttribute("msg", message);
        session.setAttribute("username", registerFrom.getUsername());

        if (registerFrom != null) {
            BeanUtils.copyProperties(registerFrom, regisrelnfo);
            User select = iUserService.select(regisrelnfo);
//            if (select == null) {
//                modelMap.addAttribute("msg", "您的账号或者密码错误");
//                return "store/login";
//            }
            session.setAttribute("userId", select.getUserId());
            session.setAttribute("username", registerFrom.getUsername());
        }
        getClassification(modelMap);
        return "store/login";
    }

//    @RequestMapping("/logout")
//    public String logout(HttpSession session) {
//        session.invalidate();
//
//        return "redirect:/";
//    }

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
            log.info("测试{}", modifyForm);

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

    //邮箱验证
    @RequestMapping("/emil")
    public void addEmil(MailUtil mailUtil, HttpServletRequest request) throws Exception {

        /*
         * emailTitle 邮件标题
         * toEmailAddress 目标邮箱地址
         * emailContent 邮件内容
         */
        String i = request.getParameter("name");
        log.info("ajax {}",i);
        int random = (int) (1 + Math.random() * 100);
        String number = Integer.toString(random);
        String emailTitle = "欢迎！";
        String emailContent = number;
        mailUtil.sendEmail(emailTitle, emailContent);
//        return "";
    }

    //找回密码
    @RequestMapping("/doGetBack")
    public String doGetBack(ModifyForm modifyForm, ModelMap model) {
        return "store/getBack";
    }
    @RequestMapping("/getBack")
    public String modifyUser(ModifyForm modifyForm, ModelMap model) {

        String email = modifyForm.getEmail();
        User getuser = iUserService.getBack(modifyForm);
        String userName = getuser.getEmail();
//        if (email!=userName) {
//
//            model.addAttribute("", "");
//        }

        return "store/index";
    }

}
