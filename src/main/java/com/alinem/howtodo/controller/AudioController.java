package com.alinem.howtodo.controller;


import com.alinem.howtodo.dto.requestDto.AudioRequestDto;
import com.alinem.howtodo.dto.responseDto.AudioResponseDto;
import com.alinem.howtodo.service.AudioService;
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
@RequestMapping("/audios")
public class AudioController {
    private final AudioService audioService;

    public AudioController(AudioService audioService) {
        this.audioService = audioService;
    }

    @PostMapping
    public ResponseEntity<AudioResponseDto> addAudio(@RequestBody AudioRequestDto requestDto){
        AudioResponseDto audioResponseDto=audioService.addAudio(requestDto);
        return ResponseEntity.ok(audioResponseDto);
    }

    @GetMapping
    public ResponseEntity<List<AudioResponseDto>> getAudios(){
        List<AudioResponseDto> audioResponseDtos =audioService.getAudios();
        return ResponseEntity.ok(audioResponseDtos);
    }




    @GetMapping("{id}")
    public ResponseEntity<AudioResponseDto> getAudio(@PathVariable("id") Long id){
        AudioResponseDto audioResponseDto= audioService.getAudio(id);
        return ResponseEntity.ok(audioResponseDto);
    }

    @PutMapping("{id}")
    public ResponseEntity<AudioResponseDto> updateAudio(@PathVariable("id") Long id,
                                                                @RequestBody AudioRequestDto requestDto){
        AudioResponseDto audioResponseDto= audioService.updateAudio(id,requestDto);
        return ResponseEntity.ok(audioResponseDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deleteAudio(@PathVariable("id") Long id){
        Boolean resultAudio=audioService.deleteAudio(id);
        return ResponseEntity.ok(resultAudio);
    }
}
