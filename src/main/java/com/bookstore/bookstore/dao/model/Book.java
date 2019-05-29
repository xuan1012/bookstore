package com.bookstore.bookstore.dao.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * <p>
 *
 * </p>
 *
 * @author xuan
 * @since 2019-05-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 书籍Id
     */
    @TableId(value = "book_id", type = IdType.AUTO)
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
