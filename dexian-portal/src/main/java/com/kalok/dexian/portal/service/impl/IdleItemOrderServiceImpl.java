package com.kalok.dexian.portal.service.impl;

import com.kalok.dexian.portal.dto.AddressParam;
import com.kalok.dexian.portal.dto.IdleItemParam;
import com.kalok.dexian.portal.entity.Address;
import com.kalok.dexian.portal.entity.IdleItemOrder;
import com.kalok.dexian.portal.mapper.IdleItemOrderMapper;
import com.kalok.dexian.portal.service.IdleItemOrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class IdleItemOrderServiceImpl implements IdleItemOrderService {

    @Autowired
    IdleItemOrderMapper idleItemOrderMapper;
    @Override
    public List<IdleItemOrder> getOrdersByType(Integer orderType) {
        return idleItemOrderMapper.getOrdersByType(orderType);
    }

    @Override
    public int createOrder(IdleItemParam idleItem, AddressParam address, Integer amount, Integer orderType) {
        IdleItemOrder order = new IdleItemOrder();
        order.setCreateTime(new Date());
        order.setLastUpdateTime(new Date());
        order.setOrderType(orderType);//订单类型:根据传入参数决定
        order.setOrderStatus(0);//订单状态:已拍下
        order.setIdleItemId(idleItem.getId());
        order.setUserId(idleItem.getUserId());
        order.setAddressId(address.getId());
        order.setOrderPrice(idleItem.getPrice().multiply(BigDecimal.valueOf(amount)));
        return idleItemOrderMapper.insertOrder(order);
    }

    @Override
    public int deleteOrder(Long orderId) {
        return idleItemOrderMapper.deleteOrder(orderId);
    }

    @Override
    public int updateStatus(Long orderId, Integer orderStatus) {
        return idleItemOrderMapper.updateStatus(orderId,orderStatus);
    }
}
