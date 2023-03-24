package com.kalok.dexian.portal.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class IdleItemParam {
    private Long id;
    private Long userId;
    private BigDecimal price;

    private String description;

    private Integer isNew;
    private Integer deliveryMethod;
}
