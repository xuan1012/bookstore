package com.bookstore.bookstore.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bookstore.bookstore.dao.*;
import com.bookstore.bookstore.dao.model.Address;
import com.bookstore.bookstore.dao.model.AllBookMessage;
import com.bookstore.bookstore.dao.model.Order;
import com.bookstore.bookstore.dao.model.Store;
import com.bookstore.bookstore.service.IOrderService;
import com.bookstore.bookstore.web.form.OrderForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;

/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author xuan
 * @since 2019-06-01
 */
@Service
@Slf4j
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {
    @Resource
    BookMessageMapper bookMessageMapper;
    @Resource
    PicturesMapper picturesMapper;
    @Resource
    AddressMapper addressMapper;
    @Resource
    StoreMapper storeMapper;
    @Resource
    OrderMapper orderMapper;

    @Override
    public List<OrderForm> initOrder(List<OrderForm> orderForms) {
        Iterator it = orderForms.iterator();
        while (it.hasNext()) {
            OrderForm next = (OrderForm) it.next();
            if ("F".equals(next.getUserAddress())) {
                it.remove();
            } else {
                Long bookId = next.getBookId();
                AllBookMessage book = bookMessageMapper.findById(bookId);
                next.setBookName(book.getBookName());
                next.setAuthor(book.getAuthor());
                next.setOrderDate(LocalDateTime.now());
                next.setOrderPrice((next.getOnePrice()).multiply(new BigDecimal(next.getOrderCount())));
                next.setPictureContent(picturesMapper.getBookPicture(bookId));
            }
        }
        return orderForms;
    }

    @Override
    public List<Address> getAddress(Long userId) {
        List<Address> address = addressMapper.findByUserId(userId);
        return address;
    }

    @Override
    public void addOrder(List<OrderForm> orderForms) {
        Iterator it = orderForms.iterator();
        while (it.hasNext()) {
            OrderForm next = (OrderForm) it.next();
            next.setOrderDate(LocalDateTime.now());
            next.setOrderPrice((next.getOnePrice()).multiply(new BigDecimal(next.getOrderCount())));
            Store store = storeMapper.findByName(next.getSellStore());
            next.setStoreId(Long.valueOf(store.getStoreId()));
            Order order = new Order();
            BeanUtils.copyProperties(next, order);
            order.setState("待支付");
            orderMapper.insert(order);
        }
    }
}
