package com.bookstore.bookstore.service;

import com.bookstore.bookstore.dao.model.Address;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bookstore.bookstore.web.form.AddressForm;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 用户地址表 服务类
 * </p>
 *
 * @author xuan
 * @since 2019-06-03
 */
public interface IAddressService extends IService<Address> {

    void add(AddressForm addressForm);

    List<Address> selectAddress(Long i);
}
