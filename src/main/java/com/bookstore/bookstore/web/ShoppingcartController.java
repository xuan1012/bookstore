package com.bookstore.bookstore.web;


import com.bookstore.bookstore.dao.model.AllShops;
import com.bookstore.bookstore.service.IShoppingCartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author xuan
 * @since 2019-05-30
 */
@Controller
@RequestMapping("/book")
public class ShoppingcartController {
    @Resource
    IShoppingCartService shoppingCartService;
    /**
    * @Description: 进入购物车页面的展示数据查询 描述
    * @Param: [session, map] 参数
    * @return: java.lang.String
    * @Author: xuan
    * @Date: 2019/6/12
    */
    @RequestMapping("/cart")
    public String shoppingCart(HttpSession session, ModelMap map) {

        if (session.getAttribute("userId") != null) {
            Long userId = (Long) session.getAttribute("userId");
            getCartShops(userId, map);
            return "store/cart";
        }
        map.addAttribute("msg", "没有商品哦");
        map.addAttribute("shops", null);

        return "store/cart";
    }

    private void getCartShops(Long userId, ModelMap map) {
        List<AllShops> allShops = shoppingCartService.getAllShops(userId);
        if (allShops.size() == 0) {
            map.addAttribute("msg", "您还没有添加商品到购物车，快去选购吧~");
        }
        map.addAttribute("shops", allShops);
    }
    /**
    * @Description: 所有页面的加入购物车功能 描述
    * @Param: [bookId, session] 参数
    * @return: java.util.Map<java.lang.String,java.lang.Object>
    * @Author: xuan
    * @Date: 2019/6/12
    */
    @RequestMapping(value = "/addToCart", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> addToCart(Long bookId, HttpSession session) {
        Map<String, Object> map = new HashMap<>(5);
        if (session.getAttribute("userId") != null) {
            Long userId = (Long) session.getAttribute("userId");
            shoppingCartService.addToCart(userId, bookId);
            map.put("msg", 0);
        } else {
            map.put("msg", 1);
        }
        return map;
    }
    /**
    * @Description: 购物车界面的删除商品功能 描述
    * @Param: [cartId, session] 参数
    * @return: java.util.Map<java.lang.String,java.lang.Object>
    * @Author: xuan
    * @Date: 2019/6/12
    */
    @ResponseBody
    @RequestMapping("/delCart")
    public Map<String, Object> delCart(Long cartId, HttpSession session) {
        Map<String, Object> map = new HashMap<>(5);
        shoppingCartService.delCartId(cartId);
        map.put("msg", "success");
        return map;
    }
    /**
    * @Description: 购物车界面的加减数量功能 描述
    * @Param: [cartId, count, session] 参数
    * @return: java.util.Map<java.lang.String,java.lang.Object>
    * @Author: xuan
    * @Date: 2019/6/12
    */
    @ResponseBody
    @RequestMapping("/updateCount")
    public Map<String, Object> updateCount(Long cartId, Long count, HttpSession session) {
        Map<String, Object> map = new HashMap<>(5);
        shoppingCartService.updateCount(cartId, count);
        map.put("msg", "success");
        return map;
    }


}
