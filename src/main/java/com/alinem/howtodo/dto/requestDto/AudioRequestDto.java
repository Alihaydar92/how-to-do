package com.alinem.howtodo.dto.requestDto;

import com.alinem.howtodo.dto.responseDto.AudioTypeResponseDto;
import com.alinem.howtodo.dto.responseDto.BlogResponseDto;
import lombok.Data;

@Data
public class AudioRequestDto {

    private Long id;

    private String url;

    private Long blogId;

    private Long audioTypeId;
}


