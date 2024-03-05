package com.alinem.howtodo.dto.responseDto;

import lombok.Data;


@Data
public class UserInfoResponseDto {
    private Long id;
    private String username;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String roles;


}
