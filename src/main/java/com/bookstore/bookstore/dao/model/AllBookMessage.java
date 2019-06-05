package com.bookstore.bookstore.dao.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @program: bookstore
 * @author: xuan
 * @create: 2019-05-29 11:45
 **/
@Data
public class AllBookMessage{
    private Long bookId;

    /**
     * 书名
     */
    private String bookName;

    /**
     * 单价
     */
    private BigDecimal bookPrice;

    /**
     * 作者
     */
    private String author;

    /**
     * 出版社
     */
    private String publishing;

    /**
     * 销量
     */
    private Long sales;

    /**
     * 出版日期
     */
    private Data publicationDate;

    /**
     * 余量
     */
    private Integer count;

    /**
     * 评分
     */
    private BigDecimal score;



    /**
     * 图片内容（地址）
     */
    private List<Picture> pictureContent;


    private List<Categories> categories;

    private Integer storeId;

    /**
     * 店铺名
     */
    private String storeName;

    /**
     * 开店区域
     */
    private String storeAddress;

    /**
     * 普通，黄金，砖石，皇冠等
     */
    private String storeLevel;

    /**
     * 开店时长
     */
    private String storeAge;

    /**
     * 店铺评分
     */
    private BigDecimal storeScore;

    /**
     * 总销量
     */
    private Long totleSales;

    /**
     * 0：正常。1：审核中。2：冻结
     */
    private String state;


}
