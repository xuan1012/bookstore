package com.bookstore.bookstore.service.impl;

import com.bookstore.bookstore.dao.model.Classification;
import com.bookstore.bookstore.dao.ClassificationMapper;
import com.bookstore.bookstore.service.IClassificationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bookstore.bookstore.service.info.ClassIficationInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 分类-h 服务实现类
 * </p>
 *
 * @author xuan
 * @since 2019-06-03
 */
@Service
@Slf4j
public class ClassificationServiceImpl extends ServiceImpl<ClassificationMapper, Classification> implements IClassificationService {

    @Override
    public List<ClassIficationInfo> classification() {

        List<ClassIficationInfo> classIfication = new ArrayList<>();
        HashMap<String,Object> hashMap = new HashMap();
        hashMap.put("two_stage",-1);
        Collection<Classification> classifications = listByMap(hashMap);
        for (Classification categories:classifications) {
            ClassIficationInfo c = new ClassIficationInfo();
            c.setClassID(categories.getClassid());
            c.setClassName(categories.getClassname());

            hashMap.put("two_stage", categories.getClassid());
            Collection<Classification> classification = listByMap(hashMap);
            c.setClassificationInfos(classification);
            classIfication.add(c);
            log.info("分类 {}", classIfication);
        }
        return classIfication;
    }
}
