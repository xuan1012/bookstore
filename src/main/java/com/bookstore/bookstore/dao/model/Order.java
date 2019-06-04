package com.bookstore.bookstore.dao.model;

    import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
* <p>
    * 订单表
    * </p>
*
* @author xuan
* @since 2019-06-01
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

            /**
            * 订单Id
            */
            @TableId(value = "order_id", type = IdType.AUTO)
    private Long orderId;

            /**
            * 下单日期
            */
    private LocalDateTime orderDate;

            /**
            * 订单价格
            */
    private BigDecimal orderPrice;

            /**
            * 订单商品
            */
    private Long bookId;

            /**
            * 订单数量
            */
    private Integer orderCount;

            /**
            * 下单用户Id
            */
    private Long userId;

            /**
            * 用户地址
            */
    private String userAddress;

            /**
            * 订单状态
            */
    private String state;

            /**
            * 店铺Id
            */
    private Long storeId;


}
