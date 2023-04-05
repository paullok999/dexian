package com.kalok.dexian.portal.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class IdleItem {
    private Long id;

    private Long userId;

    private BigDecimal price;

    private String description;

    private Integer isNew;

    private Long browseCount;

    private Long favoriteCount;

    private Integer itemStatus;
    private Integer deliveryMethod;

    private Date releaseTime;
}
