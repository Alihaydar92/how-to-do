package com.alinem.howtodo.controller;


import com.alinem.howtodo.dto.requestDto.PhotoRequestDto;
import com.alinem.howtodo.dto.responseDto.PhotoResponseDto;
import com.alinem.howtodo.service.PhotoService;
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
@RequestMapping("/photos")
public class PhotoController {
    private final PhotoService photoService;

    public PhotoController(PhotoService photoService) {
        this.photoService = photoService;
    }

    @PostMapping
    public ResponseEntity<PhotoResponseDto> addPhoto(@RequestBody PhotoRequestDto requestDto){
        PhotoResponseDto photoResponseDto=photoService.addPhoto(requestDto);
        return ResponseEntity.ok(photoResponseDto);
    }

    @GetMapping
    public ResponseEntity<List<PhotoResponseDto>> getPhotos(){
        List<PhotoResponseDto> photoResponseDtos =photoService.getPhotos();
        return ResponseEntity.ok(photoResponseDtos);
    }


    

    @GetMapping("{id}")
    public ResponseEntity<PhotoResponseDto> getPhoto(@PathVariable("id") Long id){
        PhotoResponseDto photoResponseDto= photoService.getPhoto(id);
        return ResponseEntity.ok(photoResponseDto);
    }

    @PutMapping("{id}")
    public ResponseEntity<PhotoResponseDto> updatePhoto(@PathVariable("id") Long id,
                                                                @RequestBody PhotoRequestDto requestDto){
        PhotoResponseDto photoResponseDto= photoService.updatePhoto(id,requestDto);
        return ResponseEntity.ok(photoResponseDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deletePhoto(@PathVariable("id") Long id){
        Boolean resultPhoto=photoService.deletePhoto(id);
        return ResponseEntity.ok(resultPhoto);
    }
}
