package com.alinem.howtodo.service;

import com.alinem.howtodo.dto.requestDto.AllBlogRequestDto;
import com.alinem.howtodo.dto.responseDto.AllBlogResponseDto;

import java.util.List;

public interface AllBlogService {

    AllBlogResponseDto addAllBlog(AllBlogRequestDto requestDto);

    List<AllBlogResponseDto> getAllBlogs();


    AllBlogResponseDto getAllBlog(Long id);

    AllBlogResponseDto updateAllBlog(Long id, AllBlogRequestDto requestDto);

    Boolean deleteAllBlog(Long id);
}
