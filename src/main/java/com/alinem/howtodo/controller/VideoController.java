package com.alinem.howtodo.controller;


import com.alinem.howtodo.dto.requestDto.VideoRequestDto;
import com.alinem.howtodo.dto.responseDto.VideoResponseDto;
import com.alinem.howtodo.service.VideoService;
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
@RequestMapping("/videos")
public class VideoController {
    private final VideoService videoService;

    public VideoController(VideoService videoService) {
        this.videoService = videoService;
    }

    @PostMapping
    public ResponseEntity<VideoResponseDto> addVideo(@RequestBody VideoRequestDto requestDto){
        VideoResponseDto videoResponseDto=videoService.addVideo(requestDto);
        return ResponseEntity.ok(videoResponseDto);
    }

    @GetMapping
    public ResponseEntity<List<VideoResponseDto>> getVideos(){
        List<VideoResponseDto> videoResponseDtos =videoService.getVideos();
        return ResponseEntity.ok(videoResponseDtos);
    }


    

    @GetMapping("{id}")
    public ResponseEntity<VideoResponseDto> getVideo(@PathVariable("id") Long id){
        VideoResponseDto videoResponseDto= videoService.getVideo(id);
        return ResponseEntity.ok(videoResponseDto);
    }

    @PutMapping("{id}")
    public ResponseEntity<VideoResponseDto> updateVideo(@PathVariable("id") Long id,
                                                                @RequestBody VideoRequestDto requestDto){
        VideoResponseDto videoResponseDto= videoService.updateVideo(id,requestDto);
        return ResponseEntity.ok(videoResponseDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deleteVideo(@PathVariable("id") Long id){
        Boolean resultVideo=videoService.deleteVideo(id);
        return ResponseEntity.ok(resultVideo);
    }
}
