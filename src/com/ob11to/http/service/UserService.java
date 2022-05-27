package com.ob11to.http.service;


import com.ob11to.http.dao.UserDao;
import com.ob11to.http.dto.CreateUserDto;
import com.ob11to.http.exception.ValidatorException;
import com.ob11to.http.mapper.CreateUserMapper;
import com.ob11to.http.validator.CreateUserValidator;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class UserService {

    private final CreateUserValidator createUserValidator = CreateUserValidator.getInstance();
    private final UserDao userDao = UserDao.getInstance();
    private final CreateUserMapper createUserMapper = CreateUserMapper.getInstance();
    private final ImageService imageService = ImageService.getInstance();

    private static final UserService USER_SERVICE_INSTANCE = new UserService();

    public static UserService getInstance(){
        return USER_SERVICE_INSTANCE;
    }

    //вернет id
    @SneakyThrows
    public Integer create(CreateUserDto createUserDto){
        //validate
        var validatorResult = createUserValidator.isValid(createUserDto);
        if(!validatorResult.isValid()){
            throw new ValidatorException(validatorResult.getErrors());
        }
        //mapper
        var userEntity = createUserMapper.mapFrom(createUserDto);
        //save Dao
        imageService.upload(userEntity.getImage(), createUserDto.getImage().getInputStream());
        userDao.save(userEntity);
        //return id
        return userEntity.getId();
    }


}
