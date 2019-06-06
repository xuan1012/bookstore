package com.bookstore.bookstore.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bookstore.bookstore.dao.*;
import com.bookstore.bookstore.dao.model.*;
import com.bookstore.bookstore.service.IOrderService;
import com.bookstore.bookstore.web.form.OrderForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.DateUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
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
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Orderbuy> implements IOrderService {
    @Resource
    BookMessageMapper bookMessageMapper;
    @Resource
    PicturesMapper picturesMapper;
    @Resource
    AddressMapper addressMapper;
    @Resource
    StoreMapper storeMapper;
    @Resource
    OrderbuyMapper orderbuyMapper;
    @Resource
    OrdergroupMapper ordergroupMapper;
    @Resource
    ShoppingcartMapper shoppingcartMapper;
    @Resource
    BookMapper bookMapper;

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
                next.setOrderDate(DateUtils.createNow().getTime());
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
    public Ordergroup addOrder(List<OrderForm> orderForms, HttpSession session) {
//        LocalDateTime now = LocalDateTime.now();
        Date now = DateUtils.createNow().getTime();
        List<Orderbuy> orderbuys = new ArrayList<>();
        Iterator it = orderForms.iterator();
        Ordergroup ordergroup = new Ordergroup();
        Ordergroup maxId = ordergroupMapper.findMaxId();
        StringBuilder stringBuilder = new StringBuilder("");
        BigDecimal money = BigDecimal.valueOf(0);
        long groupId = 0L;
        if (maxId == null) {
            groupId = 1L;
        } else {
            groupId = maxId.getGroupId() + 2;
        }
        ordergroup.setGroupId(groupId);
        ordergroup.setCreatDate(now);
        while (it.hasNext()) {
            OrderForm next = (OrderForm) it.next();
            next.setOrderDate(now);
            next.setOrderPrice((next.getOnePrice()).multiply(new BigDecimal(next.getOrderCount())));
            Store store = storeMapper.findByName(next.getSellStore());
            AllBookMessage book = bookMessageMapper.findById(next.getBookId());
            Book upBook = new Book();
            BeanUtils.copyProperties(book, upBook);
            upBook.setSales(upBook.getSales() + 1);
            bookMapper.updateById(upBook);
            next.setBookName(book.getBookName());
            next.setStoreId(Long.valueOf(store.getStoreId()));
            Orderbuy orderbuy = new Orderbuy();
            BeanUtils.copyProperties(next, orderbuy);
            orderbuy.setState("待支付");
            orderbuy.setLevel(groupId);
            money = money.add(orderbuy.getOrderPrice());
            stringBuilder.append(next.getBookName()).append("数量:").append(next.getOrderCount()).append(";");
            shoppingcartMapper.deleteById(next.getCartId());
            orderbuys.add(orderbuy);
            orderbuyMapper.insert(orderbuy);
        }
        ordergroup.setGroupContent(stringBuilder.toString());
        ordergroup.setMoney(money);
        ordergroupMapper.insert(ordergroup);
        session.setAttribute("ordersTodo", orderbuys);
        return ordergroup;
    }
}

