package com.alinem.howtodo.repository;

import com.alinem.howtodo.entity.Audio;
import com.alinem.howtodo.entity.Blog;
import com.alinem.howtodo.entity.Photo;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface AudioRepository extends JpaRepository<Audio,Long> {


    @EntityGraph(attributePaths = {"blog","audioType","blog.topic"})
    List<Audio> findAllByBlogId(Long blogId);
}
