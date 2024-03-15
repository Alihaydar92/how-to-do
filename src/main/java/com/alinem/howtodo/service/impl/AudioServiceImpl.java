package com.alinem.howtodo.service.impl;

import com.alinem.howtodo.dto.requestDto.AudioRequestDto;
import com.alinem.howtodo.dto.responseDto.AudioResponseDto;
import com.alinem.howtodo.entity.Audio;
import com.alinem.howtodo.entity.AudioType;
import com.alinem.howtodo.entity.Blog;
import com.alinem.howtodo.repository.AudioRepository;
import com.alinem.howtodo.service.AudioService;
import com.alinem.howtodo.service.AudioTypeService;
import com.alinem.howtodo.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AudioServiceImpl implements AudioService {
    private  final AudioRepository audioRepository;
    private final BlogService blogService;
    private final AudioTypeService audioTypeService;
    private final ModelMapper modelMapper;

    @Override
    public AudioResponseDto addAudio(AudioRequestDto requestDto) {
        Audio audio= new Audio();
        if (requestDto.getBlogId()==null){
            throw  new IllegalArgumentException("audio at least one topic");
        }
        Blog blog= blogService.getBlogSelf(requestDto.getBlogId());
        audio.setBlog(blog);

        if (requestDto.getAudioTypeId()==null){
            throw  new IllegalArgumentException("audio at least one topic");
        }
        AudioType audioType= audioTypeService.getAudioTypeSelf(requestDto.getAudioTypeId());
        audio.setAudioType(audioType);
        audio.setUrl(requestDto.getUrl());

        return modelMapper.map(audioRepository.save(audio), AudioResponseDto.class );

    }




    @Override
    public List<AudioResponseDto> getAudios() {

        List<AudioResponseDto> list = new ArrayList<>();

       audioRepository.findAll().stream().forEach(obj->{
          list.add(modelMapper.map(obj,AudioResponseDto.class));
      });
        return list;


    }


    @Override
    public AudioResponseDto getAudio(Long id) {
        Audio audio= getAudioSelf(id);
        return modelMapper.map(audio,AudioResponseDto.class);
    }

    @Override
    public Audio getAudioSelf(Long id) {
        return audioRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("cannot find audio with id:" +id));
    }


    @Override
    public AudioResponseDto updateAudio(Long id, AudioRequestDto requestDto) {
        Audio audio= getAudioSelf(id);

        if(requestDto.getBlogId()!=null){
            Blog blog=blogService.getBlogSelf(requestDto.getBlogId());
            audio.setBlog(blog);
        }
        if(requestDto.getAudioTypeId()!=null){
            AudioType audioType=audioTypeService.getAudioTypeSelf(requestDto.getAudioTypeId());
            audio.setAudioType(audioType);
        }
        audio.setUrl(requestDto.getUrl());
        audioRepository.save(audio);
        return modelMapper.map(audio,AudioResponseDto.class);
    }

    @Override
    public Boolean deleteAudio(Long id) {
        Optional<Audio> audio=audioRepository.findById(id);

        if(audio.isPresent()){
            audioRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<AudioResponseDto> getAudioByBlogId(Long blogId) {
        List<AudioResponseDto> list = new ArrayList<>();


        audioRepository.findAllByBlogId(blogId).stream().forEach(obj->{
            list.add(modelMapper.map(obj,AudioResponseDto.class));
        });
        System.out.println(list.get(0));
        return list;
    }


}
