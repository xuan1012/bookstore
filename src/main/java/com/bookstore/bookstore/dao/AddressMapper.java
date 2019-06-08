package com.bookstore.bookstore.dao;

import com.bookstore.bookstore.dao.model.Address;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 用户地址表 Mapper 接口
 * </p>
 *
 * @author xuan
 * @since 2019-06-03
 */
public interface AddressMapper extends BaseMapper<Address> {

    List<Address> findByUserId(@Param("userId") Long userId);

    List<Address> select(Long i);

    void add(Address address);
}
