package com.kalok.dexian.chat.api.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.kalok.dexian.chat.api.converter.MyContentConverter;
import com.kalok.dexian.chat.api.data.GroupMsgContentData;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

/**
 * (GroupMsgContent)实体类
 *
 * @author makejava
 * @since 2020-06-17 10:46:50
 */

public class GroupMsgContent implements Serializable {
    private static final long serialVersionUID = 980328865610261046L;
    /**
    * 消息内容编号
    */

    private Integer id;
    /**
    * 发送者的编号
    */

    private Integer fromId;
    /**
    * 发送者的昵称
    */

    private String fromName;
    /**
    * 发送者的头像
    */

    private String fromProfile;
    /**
    * 消息发送时间
    */

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;
    /**
    * 消息内容
    */

    private String content;
    /**
    * 消息类型编号
    */

    private Integer messageTypeId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFromId() {
        return fromId;
    }

    public void setFromId(Integer fromId) {
        this.fromId = fromId;
    }

    public String getFromName() {
        return fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    public String getFromProfile() {
        return fromProfile;
    }

    public void setFromProfile(String fromProfile) {
        this.fromProfile = fromProfile;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getMessageTypeId() {
        return messageTypeId;
    }

    public void setMessageTypeId(Integer messageTypeId) {
        this.messageTypeId = messageTypeId;
    }

    @Override
    public String toString() {
        return "GroupMsgContent{" +
                "id=" + id +
                ", fromId=" + fromId +
                ", fromName='" + fromName + '\'' +
                ", fromProfile='" + fromProfile + '\'' +
                ", createTime=" + createTime +
                ", content='" + content + '\'' +
                ", messageTypeId=" + messageTypeId +
                '}';
    }

    /**
     * 将数据库实体转化为Excel的数据实体
     * @param groupMsgContent
     * @return
     */
    public static GroupMsgContentData convertEntityToData(GroupMsgContent groupMsgContent) throws MalformedURLException {
        GroupMsgContentData groupMsgContentData = new GroupMsgContentData();
        groupMsgContentData.setFromId(groupMsgContent.getFromId());
        groupMsgContentData.setId(groupMsgContent.getId());
        groupMsgContentData.setFromName(groupMsgContent.getFromName());
        groupMsgContentData.setCreateTime(groupMsgContent.getCreateTime());
        //转化为URL以Excel导出图片
        groupMsgContentData.setFromProfile(new URL(groupMsgContent.getFromProfile()));
        //根据消息类型设置内容
        if (groupMsgContent.getMessageTypeId()==1){
            groupMsgContentData.setTextContent(groupMsgContent.getContent());
        }
        if (groupMsgContent.getMessageTypeId()==2){
            groupMsgContentData.setImageContent(new URL(groupMsgContent.getContent()));
        }

        return  groupMsgContentData;
    }
}
