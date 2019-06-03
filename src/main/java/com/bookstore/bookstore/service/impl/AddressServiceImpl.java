package com.bookstore.bookstore.service.impl;

import com.bookstore.bookstore.dao.model.Address;
import com.bookstore.bookstore.dao.AddressMapper;
import com.bookstore.bookstore.service.IAddressService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户地址表 服务实现类
 * </p>
 *
 * @author xuan
 * @since 2019-06-03
 */
@Service
public class AddressServiceImpl extends ServiceImpl<AddressMapper, Address> implements IAddressService {

}
