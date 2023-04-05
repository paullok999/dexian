package com.kalok.dexian.portal.mapper;

import com.kalok.dexian.portal.entity.PostImage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PostImageMapper {
    int insertAllImagesByPostId(List<PostImage> images, @Param("postId") Long postId);

    int updateAllImagesByPostId(List<PostImage> images, @Param("postId") Long postId);

    List<PostImage> getAllImagesByPostId(@Param("postId") Long postId);

    int deleteAllImagesByPostId(Long postId);
}
