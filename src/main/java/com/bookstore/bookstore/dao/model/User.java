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
* @since 2019-05-30
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    public class User implements Serializable {

    private static final long serialVersionUID = 1L;

            /**
            * 用户Id
            */
            @TableId(value = "user_id", type = IdType.AUTO)
    private Long userId;

            /**
            * 用户名
            */
    private String username;

            /**
            * 密码
            */
    private String password;

            /**
            * 手机
            */
    private String phone;

            /**
            * 性别M/F
            */
    private String sex;

            /**
            * 邮箱
            */
    private String email;

            /**
            * 身份证号
            */
    private String identityCard;

            /**
            * 头像
            */
    private String avatar;

            /**
            * 0：正常。1：审核中。2：冻结
            */
    private String state;


}
