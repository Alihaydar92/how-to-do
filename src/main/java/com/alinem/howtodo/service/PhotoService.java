package com.alinem.howtodo.service;

import com.alinem.howtodo.dto.requestDto.PhotoRequestDto;
import com.alinem.howtodo.dto.responseDto.PhotoResponseDto;
import com.alinem.howtodo.entity.Photo;

import java.util.List;


public interface PhotoService {
    PhotoResponseDto addPhoto(PhotoRequestDto requestDto);

    List<PhotoResponseDto> getPhotos();

    PhotoResponseDto getPhoto(Long id);

    Photo getPhotoSelf(Long id);
    PhotoResponseDto updatePhoto(Long id, PhotoRequestDto requestDto);

    Boolean deletePhoto(Long id);

}
