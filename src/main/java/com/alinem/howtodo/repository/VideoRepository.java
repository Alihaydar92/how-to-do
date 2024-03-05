package com.alinem.howtodo.repository;

import com.alinem.howtodo.entity.Photo;
import com.alinem.howtodo.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;


public interface VideoRepository extends JpaRepository<Video,Long> {


}
