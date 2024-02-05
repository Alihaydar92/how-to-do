package com.alinem.howtodo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@ComponentScan("com.alinem.howtodo.entity")
public class HowtodoApplication {

    public static void main(String[] args) {
        SpringApplication.run(HowtodoApplication.class, args);
    }

}
