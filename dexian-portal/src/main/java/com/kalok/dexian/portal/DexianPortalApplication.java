package com.kalok.dexian.portal;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Slf4j
@SpringBootApplication
@EnableTransactionManagement //开启声明式事务
public class DexianPortalApplication {

    public static void main(String[] args) {
        SpringApplication.run(DexianPortalApplication.class, args);
        log.info("dexian-portal服务启动");
    }

}
