package com.alinem.howtodo.dto.requestDto;

import com.alinem.howtodo.dto.responseDto.BlogResponseDto;
import lombok.Data;


@Data
public class PhotoRequestDto {

    private Long id;

    private String base64;



    private Long blogId;
}


