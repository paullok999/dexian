package com.kalok.dexian.portal.mapper;

import com.kalok.dexian.portal.entity.Address;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AddressMapper {
    List<Address> queryAll(@Param("userId") Long userId);

    int insertAddress(Address address);

    int updateAddress(Address address);

    int deleteAddressByAddressId(@Param("addressId")Long addressId);
}
