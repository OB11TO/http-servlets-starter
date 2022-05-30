package com.ob11to.http.mapper;

import com.ob11to.http.dto.UserDto;
import com.ob11to.http.entity.User;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class UserMapper implements Mapper<User, UserDto> {

    private static final UserMapper USER_MAPPER = new UserMapper();
    
    @Override
    public UserDto mapFrom(User object) {
        return UserDto.builder()
                .id(object.getId())
                .name(object.getName())
                .image(object.getImage())
                .birthday(object.getBirthday())
                .email(object.getEmail())
                .password(object.getPassword())
                .role(object.getRole())
                .gender(object.getGender())
                .build();
    }

    public static UserMapper getInstance(){
        return USER_MAPPER;
    }
}
