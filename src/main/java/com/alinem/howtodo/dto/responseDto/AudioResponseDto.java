package com.alinem.howtodo.dto.responseDto;

import com.alinem.howtodo.entity.AudioType;
import com.alinem.howtodo.entity.Blog;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class AudioResponseDto {

    private Long id;

    private String url;

    private BlogResponseDto blog;

    private AudioTypeResponseDto audioType;
}


