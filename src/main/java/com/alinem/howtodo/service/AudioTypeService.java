package com.alinem.howtodo.service;

import com.alinem.howtodo.dto.requestDto.AudioTypeRequestDto;
import com.alinem.howtodo.dto.responseDto.AudioTypeResponseDto;

import java.util.List;

public interface AudioTypeService {

    AudioTypeResponseDto addAudioType(AudioTypeRequestDto requestDto);

    List<AudioTypeResponseDto> getAudioTypes();


    AudioTypeResponseDto getAudioType(Long id);
    AudioTypeResponseDto updateAudioType(Long id, AudioTypeRequestDto requestDto);

    Boolean deleteAudioType(Long id);
}
