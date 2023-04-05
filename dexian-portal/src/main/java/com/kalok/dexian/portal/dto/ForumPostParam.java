package com.kalok.dexian.portal.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ForumPostParam {
    private Long id;
    private Long userId;
    private String postContent;
    private Date releaseTime;
}
