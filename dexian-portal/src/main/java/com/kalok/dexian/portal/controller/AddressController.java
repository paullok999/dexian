package com.kalok.dexian.portal.controller;

import com.kalok.dexian.common.api.CommonResult;
import com.kalok.dexian.common.api.ResultCode;
import com.kalok.dexian.portal.domain.User;
import com.kalok.dexian.portal.domain.Address;
import com.kalok.dexian.portal.dto.AddressParam;
import com.kalok.dexian.portal.service.AddressService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 地址管理
 */
@RequestMapping(path = "/address")
@Controller
public class AddressController {

    @Autowired
    private AddressService addressService;

    /**
     * TODO:查询指定用户的寄件/收货/退货地址
     */
    @RequestMapping(path = "/query/{userId}")
    @ResponseBody
    public CommonResult<List<Address>> queryAddress(@PathVariable Long userId){
        if(userId == null)return CommonResult.failed(ResultCode.VALIDATE_FAILED);
        List<Address> list = addressService.queryAddressesByUserId(userId);
        return CommonResult.success(list,"查询地址成功");
    }


    @RequestMapping(path = "/add",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult addAddress(@RequestBody Address address){
        int count = addressService.insertAddress(address);
        if(count > 0){
            return CommonResult.success(ResultCode.SUCCESS,"新增地址成功");
        }
        return CommonResult.failed(ResultCode.FAILED,"新增地址失败");
    }

    @RequestMapping(path = "/update/{addressId}")
    @ResponseBody
    public CommonResult updateAddress(@PathVariable("addressId") Long addressId, @RequestBody AddressParam addressParam){
        int count = addressService.updateAddressByAddressId(addressId,addressParam);
        if(count > 0){
            return CommonResult.success(ResultCode.SUCCESS,"修改地址成功");
        }
        return CommonResult.failed(ResultCode.FAILED,"修改地址失败");
    }

    @RequestMapping(path = "/delete/{addressId}")
    @ResponseBody
    public CommonResult deleteAddress(@PathVariable("addressId") Long addressId){
        int count = addressService.deleteAddress(addressId);
        if(count > 0){
            return CommonResult.success(ResultCode.SUCCESS,"删除成功");
        }
        return CommonResult.failed(ResultCode.FAILED,"删除地址失败");
    }
}