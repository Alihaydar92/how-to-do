package com.alinem.howtodo.repository;

import com.alinem.howtodo.entity.Blog;
import com.alinem.howtodo.entity.Photo;
import com.alinem.howtodo.entity.Video;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PhotoRepository extends JpaRepository<Photo,Long> {

    @EntityGraph(attributePaths = {"blog","blog.topic"})
    List<Photo> findAllByBlogId(Long blogId);
}
