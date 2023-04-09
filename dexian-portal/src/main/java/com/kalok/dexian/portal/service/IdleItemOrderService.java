package com.kalok.dexian.portal.service;

import com.kalok.dexian.portal.dto.AddressParam;
import com.kalok.dexian.portal.dto.IdleItemParam;
import com.kalok.dexian.portal.entity.Address;
import com.kalok.dexian.portal.entity.IdleItemOrder;

import java.util.List;

public interface IdleItemOrderService {
    List<IdleItemOrder> getOrdersByType(Integer orderType);

    int createOrder(IdleItemParam idleItem, AddressParam address, Integer amount, Integer orderType);

    int deleteOrder(Long orderId);

    int updateStatus(Long orderId, Integer orderStatus);
}
