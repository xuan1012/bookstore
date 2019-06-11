package com.bookstore.bookstore.dao.model;

import java.math.BigDecimal;

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
public class Store implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 店铺Id
     */
    @TableId(value = "store_id", type = IdType.AUTO)
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
