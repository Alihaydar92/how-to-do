package com.alinem.howtodo.service;

import com.alinem.howtodo.dto.requestDto.AudioRequestDto;
import com.alinem.howtodo.dto.responseDto.AudioResponseDto;
import com.alinem.howtodo.dto.responseDto.BlogTopicResponseDto;
import com.alinem.howtodo.entity.Audio;

import java.util.List;


public interface AudioService {
    AudioResponseDto addAudio(AudioRequestDto requestDto);

    List<AudioResponseDto> getAudios();

    AudioResponseDto getAudio(Long id);

    Audio getAudioSelf(Long id);
    AudioResponseDto updateAudio(Long id, AudioRequestDto requestDto);

    Boolean deleteAudio(Long id);

    List<AudioResponseDto> getAudioByBlogId(Long blogId);

}
