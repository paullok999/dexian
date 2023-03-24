package com.kalok.dexian.portal.domain;

import lombok.Data;

/**
 * 用户地址实体类
 */
@Data
public class Address {

    private Long id;

    private Long userId;

    private String name;

    private Integer type;

    private String phoneNumber;

    private Integer defaultStatus;

    private String postCode;

    private String province;

    private String city;

    private String region;

    private String detailAddress;
}
