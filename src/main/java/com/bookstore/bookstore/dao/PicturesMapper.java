package com.bookstore.bookstore.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bookstore.bookstore.dao.model.Picture;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xuan
 * @since 2019-05-29
 */
public interface PicturesMapper extends BaseMapper<Picture> {
        List<Picture> getBookPicture(@Param("bookId") Long bookId);
}
