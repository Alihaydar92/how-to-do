package com.alinem.howtodo.controller;


import com.alinem.howtodo.dto.requestDto.BlogRequestDto;
import com.alinem.howtodo.dto.responseDto.BlogResponseDto;
import com.alinem.howtodo.dto.responseDto.BlogTopicResponseDto;
import com.alinem.howtodo.service.BlogService;
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
@RequestMapping("/blogs")
public class BlogController {
    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @PostMapping
    public ResponseEntity<BlogResponseDto> addBlog(@RequestBody BlogRequestDto requestDto){
        BlogResponseDto blogResponseDto=blogService.addBlog(requestDto);
        return ResponseEntity.ok(blogResponseDto);
    }

    @GetMapping
    public ResponseEntity<List<BlogResponseDto>> getBlogs(){
        List<BlogResponseDto> blogResponseDtos =blogService.getBlogs();
        return ResponseEntity.ok(blogResponseDtos);
    }


    @GetMapping("/byTopicId/{topicId}")
    public ResponseEntity<List<BlogTopicResponseDto>> getBlogsByTopicId(@PathVariable("topicId") Long topicId){
        List<BlogTopicResponseDto> blogResponseDtos =blogService.getBlogsByTopicId(topicId);
        return ResponseEntity.ok(blogResponseDtos);
    }

    @GetMapping("{id}")
    public ResponseEntity<BlogResponseDto> getBlog(@PathVariable("id") Long id){
        BlogResponseDto blogResponseDto= blogService.getBlog(id);
        return ResponseEntity.ok(blogResponseDto);
    }

    @PutMapping("{id}")
    public ResponseEntity<BlogResponseDto> updateBlog(@PathVariable("id") Long id,
                                                                @RequestBody BlogRequestDto requestDto){
        BlogResponseDto blogResponseDto= blogService.updateBlog(id,requestDto);
        return ResponseEntity.ok(blogResponseDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deleteBlog(@PathVariable("id") Long id){
        Boolean resultBlog=blogService.deleteBlog(id);
        return ResponseEntity.ok(resultBlog);
    }
}
