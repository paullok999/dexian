package com.kalok.dexian.portal.mapper;

import com.kalok.dexian.portal.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    User getUserByUserName(@Param("username") String username);

    void insertUser(User user);

    int updateUser(User user);

    int updateLoginTime(User user);
}
