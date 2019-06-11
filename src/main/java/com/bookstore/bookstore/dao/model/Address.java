package com.bookstore.bookstore.dao.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 用户地址表
 * </p>
 *
 * @author xuan
 * @since 2019-06-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 地址Id
     */
    @TableId(value = "address_id", type = IdType.AUTO)
    private Long addressId;

    /**
     * 用户Id
     */
    private Long userId;

    /**
     * 详细地址
     */
    private String content;

    /**
     * 区域
     */
    private String area;

    /**
     * 邮编
     */
    private Integer postcode;

    /**
     * 是否为默认地址
     */
    private String defaultAddress;

    /**
     * 手机号
     */
    private Integer phone;

    private String people;
}
