package com.alinem.howtodo.service.impl;

import com.alinem.howtodo.dto.requestDto.VideoRequestDto;
import com.alinem.howtodo.dto.responseDto.VideoResponseDto;
import com.alinem.howtodo.entity.Video;
import com.alinem.howtodo.entity.Blog;
import com.alinem.howtodo.repository.VideoRepository;
import com.alinem.howtodo.service.VideoService;
import com.alinem.howtodo.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VideoServiceImpl implements VideoService {
    private  final VideoRepository videoRepository;
    private final BlogService blogService;
    private final ModelMapper modelMapper;

    @Override
    public VideoResponseDto addVideo(VideoRequestDto requestDto) {
        Video video= new Video();
        if (requestDto.getBlogId()==null){
            throw  new IllegalArgumentException("video at least one topic");
        }
        Blog blog= blogService.getBlogSelf(requestDto.getBlogId());
        video.setBlog(blog);


        video.setUrl(requestDto.getUrl());

        return modelMapper.map(videoRepository.save(video), VideoResponseDto.class );

    }




    @Override
    public List<VideoResponseDto> getVideos() {

        List<VideoResponseDto> list = new ArrayList<>();

       videoRepository.findAll().stream().forEach(obj->{
          list.add(modelMapper.map(obj,VideoResponseDto.class));
      });
        return list;


    }


    @Override
    public VideoResponseDto getVideo(Long id) {
        Video video= getVideoSelf(id);
        return modelMapper.map(video,VideoResponseDto.class);
    }

    @Override
    public Video getVideoSelf(Long id) {
        return videoRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("cannot find video with id:" +id));
    }


    @Override
    public VideoResponseDto updateVideo(Long id, VideoRequestDto requestDto) {
        Video video= getVideoSelf(id);

        if(requestDto.getBlogId()!=null){
            Blog blog=blogService.getBlogSelf(requestDto.getBlogId());
            video.setBlog(blog);
        }

        video.setUrl(requestDto.getUrl());

        videoRepository.save(video);
        return modelMapper.map(video,VideoResponseDto.class);
    }

    @Override
    public Boolean deleteVideo(Long id) {
        Optional<Video> video=videoRepository.findById(id);

        if(video.isPresent()){
            videoRepository.deleteById(id);
            return true;
        }
        return false;
    }


}
