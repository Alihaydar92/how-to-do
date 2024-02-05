package com.alinem.howtodo.repository;

import com.alinem.howtodo.entity.Topic;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TopicRepository extends JpaRepository<Topic,Long> {

    @EntityGraph
    List<Topic> findAll();

    @EntityGraph
    Optional<Topic> findById(Long id);
}
