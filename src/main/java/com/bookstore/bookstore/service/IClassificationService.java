package com.bookstore.bookstore.service;

import com.bookstore.bookstore.dao.model.Classification;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bookstore.bookstore.service.info.ClassIficationInfo;

import java.util.List;

/**
 * <p>
 * 分类-h 服务类
 * </p>
 *
 * @author xuan
 * @since 2019-06-03
 */
public interface IClassificationService extends IService<Classification> {

    List<ClassIficationInfo> classification();


}
