package com.bookstore.bookstore.service.impl;

import com.bookstore.bookstore.dao.UserMapper;
import com.bookstore.bookstore.dao.model.Address;
import com.bookstore.bookstore.dao.AddressMapper;
import com.bookstore.bookstore.service.IAddressService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bookstore.bookstore.web.form.AddressForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.xml.ws.Action;

/**
 * <p>
 * 用户地址表 服务实现类
 * </p>
 *
 * @author xuan
 * @since 2019-06-03
 */
@Service
@Slf4j
public class AddressServiceImpl extends ServiceImpl<AddressMapper, Address> implements IAddressService {

    @Resource
    private AddressMapper addressMapper;

    @Override
    public void add(AddressForm addressForm) {

        Address address = new Address();

        BeanUtils.copyProperties(addressForm,address);

        addressMapper.add(address);


    }
}
