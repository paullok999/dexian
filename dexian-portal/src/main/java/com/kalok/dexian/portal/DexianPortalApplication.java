package com.kalok.dexian.portal;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@Slf4j
@SpringBootApplication
public class DexianPortalApplication {

    public static void main(String[] args) {
        SpringApplication.run(DexianPortalApplication.class, args);
        log.info("dexian-portal服务启动");
    }

}
