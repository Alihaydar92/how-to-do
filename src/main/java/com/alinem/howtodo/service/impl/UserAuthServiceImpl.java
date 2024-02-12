package com.alinem.howtodo.service.impl;


import com.alinem.howtodo.entity.Users;
import com.alinem.howtodo.repository.UserRepository;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@ComponentScan("com.alinem.howtodo.*")
public class UserAuthServiceImpl implements UserDetailsService {


    final
    UserRepository userRepository;

    public UserAuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users inDB = userRepository.findByUsername(username);

        if(inDB==null)
            throw  new UsernameNotFoundException("user not found");
        return inDB;

    }
}
