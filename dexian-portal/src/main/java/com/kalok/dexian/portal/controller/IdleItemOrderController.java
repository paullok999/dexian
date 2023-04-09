package com.kalok.dexian.portal.controller;

import com.kalok.dexian.common.api.CommonResult;
import com.kalok.dexian.common.tool.MapAndObjectUtil;
import com.kalok.dexian.portal.dto.AddressParam;
import com.kalok.dexian.portal.dto.IdleItemParam;
import com.kalok.dexian.portal.entity.Address;
import com.kalok.dexian.portal.entity.IdleItemOrder;
import com.kalok.dexian.portal.service.IdleItemOrderService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/order")
@Controller
public class IdleItemOrderController {

    @Autowired
    IdleItemOrderService idleItemOrderService;

    /**
     * 获取所有的订单(根据类型)
     * @return
     */
    @RequestMapping(value = "/getAll/{orderType}",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getAllOrders(@PathVariable("orderType")Integer orderType){
        List<IdleItemOrder> orders = idleItemOrderService.getOrdersByType(orderType);
        if(orders.size() == 0){
            return CommonResult.success("暂时没有订单哟~");
        }
        return CommonResult.success(orders,"获取订单数据成功~");
    }

    /**
     * 生成订单
     * @return
     */
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult createOrder(@RequestBody Map<String,Object> paramMap){
        Map<String, Object> idleItemMap = (Map<String, Object>) paramMap.get("idleItem");
        IdleItemParam idleItem = (IdleItemParam) MapAndObjectUtil.MapToObject(idleItemMap, IdleItemParam.class);
        Integer amount = (Integer) paramMap.get("amount");
        Integer orderType = (Integer) paramMap.get("orderType");
        Map<String, Object> addressMap = (Map<String, Object>) paramMap.get("address");
        AddressParam address = (AddressParam) MapAndObjectUtil.MapToObject(addressMap, AddressParam.class);
        int count = idleItemOrderService.createOrder(idleItem,address,amount,orderType);
        if(count > 0){
            return CommonResult.success("订单创建成功~");
        }
        return CommonResult.failed("订单创建失败~");
    }
    /**
     * 删除订单
     * @return
     */
    @RequestMapping(value = "/delete/{orderId}",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult deleteOrder(@PathVariable("orderId")Long orderId){
        int count = idleItemOrderService.deleteOrder(orderId);
        if(count > 0){
            return CommonResult.success("删除订单成功~");
        }
        return CommonResult.failed("删除订单失败~");
    }
    /**
     * 更新订单的状态
     * @return
     */
    @RequestMapping(value = "/updateStatus",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateOrderStatus(@RequestParam Long orderId,
                                          @RequestParam Integer orderStatus){
        int count = idleItemOrderService.updateStatus(orderId,orderStatus);
        if(count > 0){
            return CommonResult.success("修改订单状态成功~");
        }
        return CommonResult.failed("修改订单状态失败~");
    }
}
