package com.kalok.dexian.portal.dto;

import lombok.Data;

import java.util.Date;

@Data
public class UserParam {

    private Long id;

    private String username;

    private String icon;

    private Integer gender;

    private String email;

    private String nickName;

}
