package com.kalok.dexian.portal.entity;

import lombok.Data;

import java.util.Date;

/**
 * 用户实体类
 */
@Data
public class User {

    private Long id;
    private String username;

    private String password;

    private String icon;

    private Integer gender;

    private String email;

    private String nickName;

    private Date createTime;

    private Date loginTime;

}
