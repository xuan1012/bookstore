package com.bookstore.bookstore.dao.model;

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
 * @since 2019-06-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Ordergroup implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "group_id")
    private Long groupId;

    private String orderNumber;

    private String groupContent;

    private BigDecimal money;

    private Date creatDate;


}
