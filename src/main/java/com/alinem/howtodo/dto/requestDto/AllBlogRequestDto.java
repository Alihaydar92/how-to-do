package com.alinem.howtodo.dto.requestDto;

import lombok.Data;

import java.util.List;

@Data
public class AllBlogRequestDto {
    private BlogRequestDto blog;
    private List<AudioRequestDto> audioRequestDtoLists;
    private List<VideoRequestDto> videoRequestDtoList;
    private List<PhotoRequestDto> photoRequestDtoList;
}
