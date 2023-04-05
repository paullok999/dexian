package com.kalok.dexian.portal.mapper;

import com.kalok.dexian.portal.entity.UserSocialRelation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserSocialMapper {

    UserSocialRelation queryRelationWithType(@Param("userId") Long userId,
                                             @Param("anotherUserId") Long anotherUserId,
                                             @Param("relationType") Integer relationType);

    int insertRelationWithType(@Param("relation") UserSocialRelation userSocialRelation);

    int deleteRelationWithType(@Param("userId") Long userId,
                               @Param("anotherUserId") Long anotherUserId,
                               @Param("relationType") Integer relationType);

    List<UserSocialRelation> getRelationWithType(@Param("userId") Long userId,
                                                 @Param("relationType") Integer relationType);
}
