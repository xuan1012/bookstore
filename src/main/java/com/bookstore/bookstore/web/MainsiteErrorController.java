package com.bookstore.bookstore.web;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;


@Controller
class MainsiteErrorController implements ErrorController {

    /** 
    * @Description: 错误页面的配置 描述
    * @Param: [request] 参数
    * @return: java.lang.String 
    * @Author: xuan 
    * @Date: 2019/6/12 
    */ 
    @RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
        //获取statusCode:401,404,500
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == 401) {
            return "/401";
        } else if (statusCode == 404) {
            return "/404";
        } else if (statusCode == 403) {
            return "/403";
        } else {
            return "/500";
        }

    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}