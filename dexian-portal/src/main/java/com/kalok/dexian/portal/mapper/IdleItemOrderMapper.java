package com.kalok.dexian.portal.mapper;

import com.kalok.dexian.portal.entity.IdleItemOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IdleItemOrderMapper {
    List<IdleItemOrder> getOrdersByType(@Param("orderType") Integer orderType);

    int insertOrder(@Param("order") IdleItemOrder order);

    int deleteOrder(@Param("orderId")Long orderId);

    int updateStatus(@Param("orderId")Long orderId,@Param("orderStatus") Integer orderStatus);
}
