package com.bookstore.bookstore.web;


import com.bookstore.bookstore.dao.model.Address;
import com.bookstore.bookstore.service.IAddressService;
import com.bookstore.bookstore.web.form.AddressForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <p>
 * 用户地址表 前端控制器
 * </p>
 *
 * @author xuan
 * @since 2019-06-03
 */
@Controller
@Slf4j
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private IAddressService iAddressService;

    /**
    * @Description: 跳转到新增收货地址的界面 描述
    * @Param: [] 参数
    * @return: java.lang.String
    * @Author: xuan
    * @Date: 2019/6/12
    */
    @RequestMapping("/do")
    private String dos() {
        return "store/address";
    }

    /**
    * @Description: 新增地址操作 描述
    * @Param: [modelMap, addressForm, session] 参数
    * @return: java.lang.String
    * @Author: xuan
    * @Date: 2019/6/12
    */
    @RequestMapping("/doaddress")
    public String doAddress(ModelMap modelMap, AddressForm addressForm, HttpSession session) {

        Long userId = (Long) session.getAttribute("userId");
        addressForm.setUserId(userId);
        String f = "F";
        String t = "T";
        if (addressForm.getDefaultAddress() != null) {
            addressForm.setDefaultAddress(f);
        } else {
            addressForm.setDefaultAddress(t);
        }
//        modelMap.addAttribute("","");
        iAddressService.add(addressForm);

        return "store/address";
    }
    /**
    * @Description: TODO 描述
    * @Param: [] 参数
    * @return: java.lang.String
    * @Author: xuan
    * @Date: 2019/6/12
    */

    @RequestMapping("/doselect")
    private String doSelect() {

        return "store/displayAddress";
    }

    /**
    * @Description: TODO修改地址 描述
    * @Param: [modelMap, session] 参数
    * @return: java.lang.String
    * @Author: xuan
    * @Date: 2019/6/12
    */
    @RequestMapping("/selectaddress")
    public String selectAddress(ModelMap modelMap, HttpSession session) {

        Long userId = (long) session.getAttribute("userId");

        List<Address> modifyAddress = iAddressService.selectAddress(userId);

        modelMap.addAttribute("selectAddress", modifyAddress);

        log.info("地址 {}", modifyAddress);

        return "store/displayAddress";
    }

    @RequestMapping("/updateAddress")
    public String updatetAddress(ModelMap modelMap, HttpSession session, AddressForm addressForm) {


        return "store/index";
    }
}
