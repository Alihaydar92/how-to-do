package com.alinem.howtodo.dto.requestDto;

import com.alinem.howtodo.dto.responseDto.TopicResponseDto;
import lombok.Data;

@Data
public class BlogRequestDto {

    private Long id;

    private String name;

    private boolean status;

    private  String text;

    private Long topicId;
}
