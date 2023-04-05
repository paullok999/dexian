package com.kalok.dexian.portal.mapper;

import com.kalok.dexian.portal.entity.PostVideo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PostVideoMapper {
    int insertAllVideosByPostId(List<PostVideo> videos,@Param("postId") Long postId);

    int updateAllVideosByPostId(List<PostVideo> videos,@Param("postId") Long postId);

    List<PostVideo> getAllVideosByPostId(@Param("postId") Long postId);

    int deleteAllVideosByPostId(@Param("postId")Long postId);
}
