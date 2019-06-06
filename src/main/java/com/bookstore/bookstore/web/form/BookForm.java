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
    private BigDecimal minBookPrice;

    private BigDecimal maxBookPrice;

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
    private String sales;

    /**
     * 出版日期
     */
    private LocalDate publicationDate;



    private String classname;

    private Long page;

    private String desc;
}
