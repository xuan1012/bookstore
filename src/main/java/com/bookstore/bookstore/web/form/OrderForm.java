package com.bookstore.bookstore.web.form;

import com.bookstore.bookstore.dao.model.Picture;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @program: bookstore
 * @author: xuan
 * @create: 2019-06-01 14:03
 **/
@Data
public class OrderForm {
    /**
     * 下单日期
     */
    private LocalDateTime orderDate;

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

    private Long cartId;

    private BigDecimal onePrice;
    /*
     * 图片
     */
    private List<Picture> pictureContent;
    /**
     * 作者
     */
    private String author;

    /**
     * 书名
     */
    private String bookName;
    /**
     * 卖家店铺
     */
    private String sellStore;
}
