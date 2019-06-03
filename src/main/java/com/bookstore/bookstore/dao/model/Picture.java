package com.bookstore.bookstore.dao.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

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
public class Picture implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Id
     */
    @TableId(value = "picture_id", type = IdType.AUTO)
    private Integer pictureId;

    /**
     * 图片内容（地址）
     */
    private String pictureContent;

    /**
     * 书的Id
     */
    private String bookId;


}
