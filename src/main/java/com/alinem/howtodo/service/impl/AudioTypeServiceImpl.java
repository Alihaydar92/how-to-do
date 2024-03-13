package com.alinem.howtodo.service.impl;

import com.alinem.howtodo.dto.requestDto.AudioTypeRequestDto;
import com.alinem.howtodo.dto.responseDto.AudioTypeResponseDto;
import com.alinem.howtodo.dto.responseDto.TopicResponseDto;
import com.alinem.howtodo.entity.AudioType;
import com.alinem.howtodo.entity.Blog;
import com.alinem.howtodo.entity.Topic;
import com.alinem.howtodo.repository.AudioTypeRepository;
import com.alinem.howtodo.service.AudioTypeService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class AudioTypeServiceImpl implements AudioTypeService {

    private final AudioTypeRepository audioTypeRepository;
    private final ModelMapper modelMapper;


    @Override
    public AudioTypeResponseDto addAudioType(AudioTypeRequestDto requestDto) {
        AudioType audioType=modelMapper.map(requestDto,AudioType.class);

        System.out.println(audioType);

        audioType=audioTypeRepository.save(audioType);

        return modelMapper.map(audioTypeRepository.save(audioType),AudioTypeResponseDto.class );
    }

    @Override
    public List<AudioTypeResponseDto> getAudioTypes() {
        List<AudioType> audioTypes=audioTypeRepository.findAll();
        List<AudioTypeResponseDto> audioTypeResponseDtos=audioTypes.stream().map(audioType -> modelMapper.map(audioType,AudioTypeResponseDto.class)).collect(Collectors.toList());
        return audioTypeResponseDtos;
    }

    @Override
    public AudioTypeResponseDto getAudioType(Long id) {
        Optional<AudioType> section = audioTypeRepository.findById(id);
        if(section.isPresent()){
            return modelMapper.map(section.get(),AudioTypeResponseDto.class);
        }
        throw new RuntimeException("AudioType tapilmadi") ;
    }

    @Override
    public AudioType getAudioTypeSelf(Long id) {
        return audioTypeRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("cannot find AudioType with id:" +id));
    }

    @Override
    public AudioTypeResponseDto updateAudioType(Long id, AudioTypeRequestDto requestDto) {
        Optional<AudioType> audioType = audioTypeRepository.findById(id);
        if(audioType.isPresent()){
            audioType.get().setName(requestDto.getName());

            return modelMapper.map(audioTypeRepository.save(audioType.get()),AudioTypeResponseDto.class);
        }
        throw new RuntimeException("AudioType tapilmadi") ;
    }

    @Override
    public Boolean deleteAudioType(Long id) {
        Optional<AudioType> audioType=audioTypeRepository.findById(id);

        if(audioType.isPresent()){
            audioTypeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
