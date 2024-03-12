package com.alinem.howtodo.service.impl;

import com.alinem.howtodo.dto.requestDto.AllBlogRequestDto;
import com.alinem.howtodo.dto.requestDto.AudioRequestDto;
import com.alinem.howtodo.dto.requestDto.PhotoRequestDto;
import com.alinem.howtodo.dto.requestDto.VideoRequestDto;
import com.alinem.howtodo.dto.responseDto.AllBlogResponseDto;
import com.alinem.howtodo.dto.responseDto.AudioResponseDto;
import com.alinem.howtodo.dto.responseDto.BlogResponseDto;
import com.alinem.howtodo.dto.responseDto.PhotoResponseDto;
import com.alinem.howtodo.dto.responseDto.VideoResponseDto;
import com.alinem.howtodo.entity.Blog;
import com.alinem.howtodo.service.AllBlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AllBlogServiceImpl implements AllBlogService {

    private final BlogServiceImpl blogService;
    private final AudioServiceImpl audioService;
    private final VideoServiceImpl videoService;
    private final PhotoServiceImpl photoService;
    
    @Transactional
    @Override
    public AllBlogResponseDto addAllBlog(AllBlogRequestDto requestDto) {
        AllBlogResponseDto allBlogResponseDto = new AllBlogResponseDto();

        List<AudioResponseDto> audioResponseDtoList = new ArrayList<>();
        List<VideoResponseDto> videoResponseDtoList = new ArrayList<>();
        List<PhotoResponseDto> photoResponseDtoList = new ArrayList<>();


        BlogResponseDto blog =blogService.addBlog(requestDto.getBlog());
        allBlogResponseDto.setBlog(blog);
        for (AudioRequestDto audioRequestDto:requestDto.getAudioRequestDtoLists()){
            audioRequestDto.setBlogId(blog.getId());
            AudioResponseDto  audioResponseDto= audioService.addAudio(audioRequestDto);
            audioResponseDtoList.add(audioResponseDto);
        }
        allBlogResponseDto.setAudioResponseDtoList(audioResponseDtoList);
        for (VideoRequestDto videoRequestDto:requestDto.getVideoRequestDtoList()){
            videoRequestDto.setBlogId(blog.getId());
            VideoResponseDto videoResponseDto= videoService.addVideo(videoRequestDto);
            videoResponseDtoList.add(videoResponseDto);
        }
        allBlogResponseDto.setVideoResponseDtoList(videoResponseDtoList);
        for (PhotoRequestDto photoRequestDto:requestDto.getPhotoRequestDtoList()){
            photoRequestDto.setBlogId(blog.getId());
            PhotoResponseDto photoResponseDto= photoService.addPhoto(photoRequestDto);
            photoResponseDtoList.add(photoResponseDto);
        }
        allBlogResponseDto.setPhotoResponseDtoList(photoResponseDtoList);

        return allBlogResponseDto;



    }

    @Override
    public List<AllBlogResponseDto> getAllBlogs() {
        return null;
    }

    @Override
    public AllBlogResponseDto getAllBlog(Long id) {
        return null;
    }

    @Override
    public AllBlogResponseDto updateAllBlog(Long id, AllBlogRequestDto requestDto) {
        return null;
    }

    @Override
    public Boolean deleteAllBlog(Long id) {
        return null;
    }
}
