package com.alinem.howtodo.repository;


import com.alinem.howtodo.entity.Video;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface VideoRepository extends JpaRepository<Video,Long> {


    @EntityGraph(attributePaths = {"blog","blog.topic"})
    List<Video> findAllByBlogId(Long blogId);

}
