package com.alinem.howtodo.repository;

import com.alinem.howtodo.entity.Blog;
import com.alinem.howtodo.entity.Photo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PhotoRepository extends JpaRepository<Photo,Long> {


}
