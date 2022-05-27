package com.ob11to.http.validator;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class ValidatorResult {
    @Getter
    private final List<Errors> errors = new ArrayList<>();

    //Если найдется ошибка
    public void add(Errors errors) {
        this.errors.add(errors);
    }

    public boolean isValid() {
        return errors.isEmpty();
    }
}
