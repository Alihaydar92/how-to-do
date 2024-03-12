package com.alinem.howtodo.dto.responseDto;

import com.alinem.howtodo.dto.requestDto.AudioRequestDto;
import com.alinem.howtodo.dto.requestDto.BlogRequestDto;
import com.alinem.howtodo.dto.requestDto.PhotoRequestDto;
import com.alinem.howtodo.dto.requestDto.VideoRequestDto;
import lombok.Data;

import java.util.List;

@Data
public class AllBlogResponseDto {
    private BlogResponseDto blog;
    private List<AudioResponseDto> audioResponseDtoList;
    private List<VideoResponseDto> videoResponseDtoList;
    private List<PhotoResponseDto> photoResponseDtoList;
}
