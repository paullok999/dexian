package com.kalok.dexian.common.tool;

import org.apache.commons.beanutils.BeanMap;
import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;

/**
 * 实现Map对象与Object互相转换的工具类
 */
public class MapAndObjectUtil {
    /**
     * 利用反射+BeanUtils将Map转为对象
     * @param paramMap
     * @param clazz
     * @return
     */
    public static Object MapToObject(Map<String,Object> paramMap,Class clazz){
        if(paramMap == null)return null;
        Object object = null;
        //开始转换(由于可能转换失败，因此需捕获异常)
        try {
            //利用class类+反射机制创建对象
            object = clazz.newInstance();
            //使用BeanUtils的populate方法将Map转换为对象
            BeanUtils.populate(object,paramMap);
        }catch (Exception e){
            e.printStackTrace();
        }
        return object;
    }

    /**
     * 将传入的对象通过BeanUtils转换成Map
     * @param object
     * @return
     */
    public static Map<?,?> ObjectToMap(Object object){
        if(object == null)return null;
        return new BeanMap(object);
    }
}
