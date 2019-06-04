package com.bookstore.bookstore.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bookstore.bookstore.dao.model.Address;
import com.bookstore.bookstore.dao.model.Order;
import com.bookstore.bookstore.web.form.OrderForm;

import java.util.List;

/**
 * <p>
 * 订单表 服务类
 * </p>
 *
 * @author xuan
 * @since 2019-06-01
 */
public interface IOrderService extends IService<Order> {
    List<OrderForm> initOrder(List<OrderForm> orderForms);
    List<Address> getAddress(Long userId);
    void addOrder(List<OrderForm> orderForms);
}
