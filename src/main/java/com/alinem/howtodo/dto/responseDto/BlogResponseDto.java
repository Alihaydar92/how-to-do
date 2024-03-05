package com.alinem.howtodo.dto.responseDto;

import com.alinem.howtodo.entity.Topic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class BlogResponseDto {

    private Long id;

    private String name;

    private boolean status;

    private  String text;

    private TopicResponseDto  topic;
}
