package com.bookstore.bookstore.dao;

import com.bookstore.bookstore.dao.model.Classification;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 分类-h Mapper 接口
 * </p>
 *
 * @author xuan
 * @since 2019-06-03
 */
public interface ClassificationMapper extends BaseMapper<Classification> {

    Classification classification(Classification classification);

}
