package com.bookstore.bookstore.web;


import com.bookstore.bookstore.dao.model.Categorie;
import com.bookstore.bookstore.service.ICategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * <p>
 * 分类表 前端控制器
 * </p>
 *
 * @author xuan
 * @since 2019-05-31
 */
@RestController
@RequestMapping("/categorie")
public class CategorieController {


@Autowired
private ICategorieService iCategorieService;

@RequestMapping("/")
public String index(ModelMap modelMap){


    return "";
}



}
