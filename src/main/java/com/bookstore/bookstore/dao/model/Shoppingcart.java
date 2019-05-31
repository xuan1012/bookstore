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
 * @since 2019-05-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Shoppingcart implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 购物车id
     */
    @TableId(value = "cart_id", type = IdType.AUTO)
    private Long cartId;

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


}
