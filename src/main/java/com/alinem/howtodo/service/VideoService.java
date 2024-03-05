package com.alinem.howtodo.service;

import com.alinem.howtodo.dto.requestDto.VideoRequestDto;
import com.alinem.howtodo.dto.responseDto.VideoResponseDto;
import com.alinem.howtodo.entity.Video;

import java.util.List;


public interface VideoService {
    VideoResponseDto addVideo(VideoRequestDto requestDto);

    List<VideoResponseDto> getVideos();

    VideoResponseDto getVideo(Long id);

    Video getVideoSelf(Long id);
    VideoResponseDto updateVideo(Long id, VideoRequestDto requestDto);

    Boolean deleteVideo(Long id);

}
