package com.bookstore.bookstore.service.info;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.bookstore.bookstore.dao.model.Book;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @program: bookstore
 * @author: xuan
 * @create: 2019-06-08 15:39
 **/
@Data
public class OrderMsg {
    /**
     * 订单Id
     */
    @TableId(value = "order_id", type = IdType.AUTO)
    private Long orderId;

    /**
     * 下单日期
     */
    private Date orderDate;

    /**
     * 订单价格
     */
    private BigDecimal orderPrice;

    /**
     * 订单商品
     */
    private Long bookId;

    /**
     * 订单数量
     */
    private Integer orderCount;

    /**
     * 下单用户Id
     */
    private Long userId;

    /**
     * 用户地址
     */
    private String userAddress;

    /**
     * 订单状态
     */
    private String state;

    /**
     * 店铺Id
     */
    private Long storeId;

    private Long level;


    private Book book;
}
