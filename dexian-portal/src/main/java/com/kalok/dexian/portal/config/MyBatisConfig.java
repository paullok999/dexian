package com.kalok.dexian.portal.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * MyBatis配置类
 */
@Configuration
@EnableTransactionManagement //开启事务
@MapperScan(value = {"com.kalok.dexian.portal.mapper","com.kalok.dexian.search.mapper"}) //扫描指定mapper包下的mapper接口
public class MyBatisConfig {
}
