package com.ob11to.http.dto;

import com.ob11to.http.entity.Gender;
import com.ob11to.http.entity.Role;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;

@Value
@Builder
public class UserDto {
    Integer id;
    String name;
    String image;
    LocalDate birthday;
    String email;
    String password;
    Role role;
    Gender gender;
}
