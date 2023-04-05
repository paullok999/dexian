package com.kalok.dexian.portal.controller;

import com.kalok.dexian.common.api.CommonResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/order")
@Controller
public class IdleItemOrderController {

    /**
     * TODO:获取所有的订单(根据类型)
     * @return
     */
    @RequestMapping("/getAll/{orderType}")
    @ResponseBody
    public CommonResult getAllOrders(@PathVariable("orderType")Integer orderType){
        return null;
    }

    /**
     * TODO:生成订单
     * @return
     */
    @RequestMapping("/create")
    @ResponseBody
    public CommonResult createOrder(){
        return null;
    }
    /**
     * TODO:删除订单
     * @return
     */
    @RequestMapping("/delete/{orderId}")
    @ResponseBody
    public CommonResult createOrder(@PathVariable("orderId")Long orderId){
        return null;
    }
    /**
     * TODO:更新订单的状态
     * @return
     */
    @RequestMapping("/update/{orderStatus}")
    @ResponseBody
    public CommonResult updateOrderStatus(@PathVariable("orderStatus")Integer orderStatus){
        return null;
    }
}
