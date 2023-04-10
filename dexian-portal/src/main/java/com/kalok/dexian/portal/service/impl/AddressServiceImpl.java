package com.kalok.dexian.portal.service.impl;

import com.kalok.dexian.portal.entity.Address;
import com.kalok.dexian.portal.dto.AddressParam;
import com.kalok.dexian.portal.mapper.AddressMapper;
import com.kalok.dexian.portal.service.AddressService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressMapper addressMapper;

    @Override
    public List<Address> queryAddressesByUserId(Long userId) {
        List<Address> list = addressMapper.queryAll(userId);
        return list;
    }

    @Override
    public int deleteAddress(Long addressId) {
        return addressMapper.deleteAddressByAddressId(addressId);
    }

    @Override
    public int updateAddressByAddressId(Long addressId, AddressParam addressParam) {
        /*将传入的参数包装成一个address对象后再更新*/
        Address address = new Address();
        BeanUtils.copyProperties(addressParam,address);
        address.setId(addressId);
        return addressMapper.updateAddress(address);
    }

    @Override
    public int insertAddress(Address address) {
        return addressMapper.insertAddress(address);
    }

    @Override
    public Address queryAddressByUserIdAndAddressId(Long userId, Long addressId) {
        return addressMapper.queryAddressByUserIdAndAddressId(userId,addressId);
    }
}
