package com.kalok.dexian.portal.dto;

import lombok.Data;

@Data
public class AddressParam {
    private Long id;
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
