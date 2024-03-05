package com.alinem.howtodo.service;

import com.alinem.howtodo.dto.requestDto.BlogRequestDto;
import com.alinem.howtodo.dto.responseDto.BlogResponseDto;
import com.alinem.howtodo.dto.responseDto.BlogTopicResponseDto;
import com.alinem.howtodo.entity.Blog;


import java.util.List;


public interface BlogService {
    BlogResponseDto addBlog(BlogRequestDto requestDto);

    List<BlogResponseDto> getBlogs();

    BlogResponseDto getBlog(Long id);

    Blog getBlogSelf(Long id);
    BlogResponseDto updateBlog(Long id, BlogRequestDto requestDto);

    Boolean deleteBlog(Long id);

    List<BlogTopicResponseDto> getBlogsByTopicId(Long topicId);
}
