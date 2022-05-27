package com.ob11to.http.mapper;

import com.ob11to.http.dto.CreateUserDto;
import com.ob11to.http.entity.Gender;
import com.ob11to.http.entity.Role;
import com.ob11to.http.entity.User;
import com.ob11to.http.util.LocalDateFormatter;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class CreateUserMapper implements Mapper<CreateUserDto,User> {

    private static final CreateUserMapper CREATE_USER_MAPPER = new CreateUserMapper();
    private static final String IMAGE_FOLDER = "user/";


    public static CreateUserMapper getInstance(){
        return CREATE_USER_MAPPER;
    }


    @Override
    public User mapFrom(CreateUserDto object) {
        return User.builder()
                .name(object.getName())
                .image(IMAGE_FOLDER + object.getImage().getSubmittedFileName())
                .birthday(LocalDateFormatter.format(object.getBirthday()))
                .email(object.getEmail())
                .password(object.getPassword())
                .role(Role.valueOf(object.getRole()))
                .gender(Gender.valueOf(object.getGender()))
                .build();
    }
}
