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
import com.bookstore.bookstore.web.uit.MailUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.net.URLDecoder;
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
//    @RequestMapping("/email")
//    public String addEmil(MailUtil mailUtil) throws Exception {
//        //随机数
//        int random = (int) (1 + Math.random() * 10000);
//        String number = Integer.toString(random);
//        String emailContent = number;
//        //标题
//        String emailTitle = "欢迎！";
//        //调用MailUtil
//        mailUtil.sendEmail(emailTitle, emailContent);
////        String toEmailAddress = InternetAddress.getLocalAddress();
//        mailUtil.sendEmail(emailTitle, emailContent);
//        return "store/index";
//    }

    //找回密码
    @RequestMapping("/doGetBack")
    public String doGetBack() {

        return "store/getBack";
    }

    @RequestMapping("/getBack")
    public String modifyUser(ModifyForm modifyForm, MailUtil mailUtil) throws Exception {
        User getuser = iUserService.getBack(modifyForm);

        return "redirect:/";
    }

    @RequestMapping("/getEmail")
    @ResponseBody
    public String getmail(@RequestBody String email, MailUtil mailUtil) throws Exception {
        email= URLDecoder.decode(email,"UTF-8");
        //收件人地址
        String get = email;
        //邮件主题
        String theme = "欢迎！你加入我们";
        //随机数或者邮件内容
        int random = (int) (1 + Math.random() * 10000);
        String number = Integer.toString(random);
        //发邮件调用的实体类
        mailUtil.sendEmail(theme,get,number);
        return "redirect:/user/doGetBack";
    }
}
