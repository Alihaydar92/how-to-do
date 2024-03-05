package com.alinem.howtodo.service.impl;

import com.alinem.howtodo.dto.requestDto.PhotoRequestDto;
import com.alinem.howtodo.dto.responseDto.PhotoResponseDto;
import com.alinem.howtodo.entity.Photo;
import com.alinem.howtodo.entity.Blog;
import com.alinem.howtodo.repository.PhotoRepository;
import com.alinem.howtodo.service.PhotoService;
import com.alinem.howtodo.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PhotoServiceImpl implements PhotoService {
    private  final PhotoRepository photoRepository;
    private final BlogService blogService;
    private final ModelMapper modelMapper;

    @Override
    public PhotoResponseDto addPhoto(PhotoRequestDto requestDto) {
        Photo photo= new Photo();
        if (requestDto.getBlogId()==null){
            throw  new IllegalArgumentException("photo at least one topic");
        }
        Blog blog= blogService.getBlogSelf(requestDto.getBlogId());
        photo.setBlog(blog);



        photo.setBase64(requestDto.getBase64());

        return modelMapper.map(photoRepository.save(photo), PhotoResponseDto.class );

    }




    @Override
    public List<PhotoResponseDto> getPhotos() {

        List<PhotoResponseDto> list = new ArrayList<>();

       photoRepository.findAll().stream().forEach(obj->{
          list.add(modelMapper.map(obj,PhotoResponseDto.class));
      });
        return list;


    }


    @Override
    public PhotoResponseDto getPhoto(Long id) {
        Photo photo= getPhotoSelf(id);
        return modelMapper.map(photo,PhotoResponseDto.class);
    }

    @Override
    public Photo getPhotoSelf(Long id) {
        return photoRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("cannot find photo with id:" +id));
    }


    @Override
    public PhotoResponseDto updatePhoto(Long id, PhotoRequestDto requestDto) {
        Photo photo= getPhotoSelf(id);

        if(requestDto.getBlogId()!=null){
            Blog blog=blogService.getBlogSelf(requestDto.getBlogId());
            photo.setBlog(blog);
        }

        photo.setBase64(requestDto.getBase64());

        photoRepository.save(photo);
        return modelMapper.map(photo,PhotoResponseDto.class);
    }

    @Override
    public Boolean deletePhoto(Long id) {
        Optional<Photo> photo=photoRepository.findById(id);

        if(photo.isPresent()){
            photoRepository.deleteById(id);
            return true;
        }
        return false;
    }


}
