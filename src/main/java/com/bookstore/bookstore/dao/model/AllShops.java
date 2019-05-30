package com.bookstore.bookstore.dao.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @program: bookstore
 * @author: xuan
 * @create: 2019-05-30 10:11
 **/
@Data
public class AllShops {
    private Long cartId;
    /**
     * 作者
     */
    private String author;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 书id
     */
    private Long bookId;

    /**
     * 数量
     */
    private Long count;


    /**
     * 书名
     */
    private String bookName;
    /**
     * 卖家店铺
     */
    private String sellStore;


    /**
     * 单价
     */
    private BigDecimal bookPrice;
    /*
     * 图片
     */
    private List<Picture> pictureContent;
}
