package com.alinem.howtodo.repository;


import com.alinem.howtodo.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {
    Optional<UserInfo> findByUsername(String username);

}
