package com.alinem.howtodo.controller;

import com.alinem.howtodo.dto.requestDto.AudioTypeRequestDto;
import com.alinem.howtodo.dto.responseDto.AudioTypeResponseDto;
import com.alinem.howtodo.service.AudioTypeService;
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
@RequestMapping("/audioTypes")
public class AudioTypeController {


    private final AudioTypeService audioTypeService;

    public AudioTypeController(AudioTypeService audioTypeService) {
        this.audioTypeService = audioTypeService;
    }


    @PostMapping
    public ResponseEntity<AudioTypeResponseDto> addAudioType(@RequestBody AudioTypeRequestDto requestDto){
        System.out.println("111");
        System.out.println(requestDto);
        AudioTypeResponseDto audioTypeResponseDto=audioTypeService.addAudioType(requestDto);
        return ResponseEntity.ok(audioTypeResponseDto);
    }

    @GetMapping
    public ResponseEntity<List<AudioTypeResponseDto>> getAudioTypes(){
        List<AudioTypeResponseDto> audioTypeResponseDtos =audioTypeService.getAudioTypes();
        return ResponseEntity.ok(audioTypeResponseDtos);
    }



    @PutMapping("{id}")
    public ResponseEntity<AudioTypeResponseDto> updateAudioType(@PathVariable("id") Long id,
                                                            @RequestBody AudioTypeRequestDto requestDto){
        AudioTypeResponseDto audioTypeResponseDto= audioTypeService.updateAudioType(id,requestDto);
        return ResponseEntity.ok(audioTypeResponseDto);
    }

    @GetMapping("{id}")
    public ResponseEntity<AudioTypeResponseDto> getSection(@PathVariable("id") Long id){
        AudioTypeResponseDto sectionResponseDto= audioTypeService.getAudioType(id);
        return ResponseEntity.ok(sectionResponseDto);
    }


    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deleteAudioType(@PathVariable("id") Long id){
        Boolean resultAudioType=audioTypeService.deleteAudioType(id);
        return ResponseEntity.ok(resultAudioType);
    }
}
