package com.bookstore.bookstore.dao.model;

    import java.io.Serializable;
    import lombok.Data;
    import lombok.EqualsAndHashCode;
    import lombok.experimental.Accessors;

/**
* <p>
    * 分类-h
    * </p>
*
* @author xuan
* @since 2019-06-03
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    public class Classification implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer classid;

    private String classname;

    private Integer twoStage;


}
