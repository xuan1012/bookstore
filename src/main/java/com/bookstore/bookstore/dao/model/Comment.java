package com.bookstore.bookstore.dao.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 评论表
 * </p>
 *
 * @author xuan
 * @since 2019-06-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 评论Id
     */
    @TableId(value = "comment_id", type = IdType.AUTO)
    private Long commentId;

    /**
     * 用户Id
     */
    private Long userId;

    /**
     * 书籍Id
     */
    private Long bookId;

    /**
     * 订单Id
     */
    private Long orderId;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 评论日期
     */
    private Date commentDate;

    /**
     * 评论级别（0：好评，1：中评，2：差评，3：卖家回复）
     */
    private Integer level;


}
