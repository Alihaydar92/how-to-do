package com.alinem.howtodo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = "com.alinem.howtodo.entity")


@SpringBootApplication
public class HowtodoApplication {

    public static void main(String[] args) {
        System.out.println("hi");
        SpringApplication.run(HowtodoApplication.class, args);
        System.out.println("hi2");
    }

}
