package com.bookstore.bookstore.dao.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

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
public class Categories implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "categories_id", type = IdType.AUTO)
    private Long categoriesId;

    /**
     * 一级分类名
     */
    private String oneCategories;

    /**
     * 二级分类名
     */
    private String twoCategories;

    /**
     * 书的Id
     */
    private String bookId;


}
