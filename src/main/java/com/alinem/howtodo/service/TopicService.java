package com.alinem.howtodo.service;

import com.alinem.howtodo.dto.requestDto.TopicRequestDto;
import com.alinem.howtodo.dto.responseDto.TopicResponseDto;
import com.alinem.howtodo.entity.Topic;

import java.util.List;

public interface TopicService {

    TopicResponseDto addTopic(TopicRequestDto requestDto);

    List<TopicResponseDto> getTopics();


    TopicResponseDto getTopic(Long id);

    Topic getTopicSelf(Long id);
    TopicResponseDto updateTopic(Long id, TopicRequestDto requestDto);

    Boolean deleteTopic(Long id);
}
