package com.kalok.dexian.portal.mapper;

import com.kalok.dexian.portal.dto.UserParam;
import com.kalok.dexian.portal.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    User getUserByUserName(@Param("username") String username);

    void insertUser(User user);

    int updateUser(User user);

    int updateLoginTime(User user);

    List<UserParam> getUsersByUserIds(@Param("userIds") List<Long> userIds);

    UserParam getUserInfoById(@Param("userId")Long userId);
}
