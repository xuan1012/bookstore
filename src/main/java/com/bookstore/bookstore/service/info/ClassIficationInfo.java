package com.bookstore.bookstore.service.info;

import com.bookstore.bookstore.dao.model.Classification;
import lombok.Data;

import java.util.Collection;
@Data
public class ClassIficationInfo {

    private int classID;

    private  String className;

    private Collection<Classification> classificationInfos;

}
