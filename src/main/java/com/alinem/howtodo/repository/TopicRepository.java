package com.alinem.howtodo.repository;

import com.alinem.howtodo.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;



public interface TopicRepository extends JpaRepository<Topic,Long> {


}
