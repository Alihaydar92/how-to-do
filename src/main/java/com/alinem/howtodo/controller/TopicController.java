package com.alinem.howtodo.controller;

import com.alinem.howtodo.dto.requestDto.TopicRequestDto;
import com.alinem.howtodo.dto.responseDto.TopicResponseDto;
import com.alinem.howtodo.service.TopicService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/topics")
public class TopicController {


    private final TopicService topicService;

    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }


    @PostMapping
    public ResponseEntity<TopicResponseDto> addTopic(@RequestBody TopicRequestDto requestDto){
        System.out.println("111");
        System.out.println(requestDto);
        TopicResponseDto topicResponseDto=topicService.addTopic(requestDto);
        return ResponseEntity.ok(topicResponseDto);
    }

    @GetMapping
    public ResponseEntity<List<TopicResponseDto>> getTopics(){
        List<TopicResponseDto> topicResponseDtos =topicService.getTopics();
        return ResponseEntity.ok(topicResponseDtos);
    }



    @PutMapping("{id}")
    public ResponseEntity<TopicResponseDto> updateTopic(@PathVariable("id") Long id,
                                                            @RequestBody TopicRequestDto requestDto){
        TopicResponseDto topicResponseDto= topicService.updateTopic(id,requestDto);
        return ResponseEntity.ok(topicResponseDto);
    }

    @GetMapping("{id}")
    public ResponseEntity<TopicResponseDto> getSection(@PathVariable("id") Long id){
        TopicResponseDto sectionResponseDto= topicService.getTopic(id);
        return ResponseEntity.ok(sectionResponseDto);
    }


    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deleteTopic(@PathVariable("id") Long id){
        Boolean resultTopic=topicService.deleteTopic(id);
        return ResponseEntity.ok(resultTopic);
    }
}
