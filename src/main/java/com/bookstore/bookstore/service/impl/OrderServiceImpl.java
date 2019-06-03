package com.bookstore.bookstore.service.impl;

import com.bookstore.bookstore.dao.model.Order;
import com.bookstore.bookstore.dao.OrderMapper;
import com.bookstore.bookstore.service.IOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author xuan
 * @since 2019-06-01
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

}
