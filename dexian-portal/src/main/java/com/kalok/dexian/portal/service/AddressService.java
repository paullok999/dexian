package com.kalok.dexian.portal.service;

import com.kalok.dexian.portal.entity.Address;
import com.kalok.dexian.portal.dto.AddressParam;

import java.util.List;

public interface AddressService {
    List<Address> queryAddressesByUserId(Long userId);

    int deleteAddress(Long addressId);

    int updateAddressByAddressId(Long addressId, AddressParam addressParam);

    int insertAddress(Address address);

    Address queryAddressByUserIdAndAddressId(Long userId, Long addressId);
}
