package com.kalok.dexian.portal.entity;

import lombok.Data;

@Data
public class ChatPersonalMessage {

    private Long id;
    private Long senderId;
    private Long receiverId;
    private String messageContent;
    private Integer messageType;


}
