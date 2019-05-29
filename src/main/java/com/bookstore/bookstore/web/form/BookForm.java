package com.bookstore.bookstore.web.form;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @program: bookstore
 * @author: xuan
 * @create: 2019-05-29 09:52
 **/
@Data
public class BookForm {
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
     * 卖家店铺
     */
    private String sellStore;

    /**
     * 销量
     */
    private Long sales;

    /**
     * 出版日期
     */
    private LocalDate publicationDate;

    /**
     * 余量
     */
    private Integer count;

    /**
     * 评分
     */
    private BigDecimal score;
}
