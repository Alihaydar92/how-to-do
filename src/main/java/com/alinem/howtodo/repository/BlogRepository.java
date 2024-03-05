package com.alinem.howtodo.repository;

import com.alinem.howtodo.entity.Blog;
import com.alinem.howtodo.entity.Topic;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;
import java.util.Optional;


public interface BlogRepository extends JpaRepository<Blog,Long> {
    @EntityGraph(attributePaths = {"topic"})
    List<Blog> findAll();

    @EntityGraph(attributePaths = {"topic"})
    Optional<Blog> findById(Long id);

    @EntityGraph(attributePaths = {"topic"})
    Optional<Blog> findAllByTopicId(Long topicId);

    @Query(value = "select id from blog ", nativeQuery = true)
    Collection<Long> findId();

}
