package com.bookstore.bookstore.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bookstore.bookstore.dao.model.Address;
import com.bookstore.bookstore.dao.model.Orderbuy;
import com.bookstore.bookstore.dao.model.Ordergroup;
import com.bookstore.bookstore.service.info.OrdergroupInfo;
import com.bookstore.bookstore.web.form.OrderForm;
import org.springframework.ui.ModelMap;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <p>
 * 订单表 服务类
 * </p>
 *
 * @author xuan
 * @since 2019-06-01
 */
public interface IOrderService extends IService<Orderbuy> {
    List<OrderForm> initOrder(List<OrderForm> orderForms);

    List<Address> getAddress(Long userId);

    Ordergroup addOrder(List<OrderForm> orderForms, HttpSession session);

    List<OrdergroupInfo> getAllOrder(ModelMap map, Long userId);

    void reBuy(Long orderId);
    void delOrder(Long orderId);
    void getShop(Long orderId);

}
