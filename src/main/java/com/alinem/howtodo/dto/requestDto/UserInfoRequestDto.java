package com.alinem.howtodo.dto.requestDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
public class UserInfoRequestDto {

    private String username;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String roles;


}
