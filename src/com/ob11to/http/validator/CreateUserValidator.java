package com.ob11to.http.validator;

import com.ob11to.http.dto.CreateUserDto;
import com.ob11to.http.entity.Gender;
import com.ob11to.http.util.LocalDateFormatter;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class CreateUserValidator implements Validator<CreateUserDto> {

    private static final CreateUserValidator CREATE_USER_VALIDATOR = new CreateUserValidator();

    public static CreateUserValidator getInstance(){
        return CREATE_USER_VALIDATOR;
    }

    @Override
    public ValidatorResult isValid(CreateUserDto object) {
        var validatorResult = new ValidatorResult();
        if(!LocalDateFormatter.isValid(object.getBirthday())){
            validatorResult.add((Errors.of("invalid.date 007","Date  gg =)")));
        }
        if(object.getName().isEmpty()){
            validatorResult.add(Errors.of("invalid.name 007","Name null gg =)"));
        }
        if(Gender.find(object.getGender()).isEmpty()){
            validatorResult.add(Errors.of("invalid.gender 007","Gender null gg =)"));
        }


        return validatorResult;
    }


}
