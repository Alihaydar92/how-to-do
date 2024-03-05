package com.alinem.howtodo.service;

import com.alinem.howtodo.dto.requestDto.AudioTypeRequestDto;
import com.alinem.howtodo.dto.responseDto.AudioTypeResponseDto;
import com.alinem.howtodo.entity.AudioType;
import com.alinem.howtodo.entity.Blog;

import java.util.List;

public interface AudioTypeService {

    AudioTypeResponseDto addAudioType(AudioTypeRequestDto requestDto);

    List<AudioTypeResponseDto> getAudioTypes();


    AudioTypeResponseDto getAudioType(Long id);
    AudioTypeResponseDto updateAudioType(Long id, AudioTypeRequestDto requestDto);
    AudioType getAudioTypeSelf(Long id);

    Boolean deleteAudioType(Long id);
}
