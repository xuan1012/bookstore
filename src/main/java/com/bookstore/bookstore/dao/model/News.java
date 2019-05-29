package com.bookstore.bookstore.dao.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

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
public class News implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 新闻Id
     */
    @TableId(value = "news_id", type = IdType.AUTO)
    private Long newsId;

    /**
     * 新闻内容
     */
    private String newsContent;

    /**
     * 新闻日期
     */
    private Date newsDate;

    /**
     * 新闻图片
     */
    private String newsPicture;

    private Long bookId;

    private BigDecimal price;
}
