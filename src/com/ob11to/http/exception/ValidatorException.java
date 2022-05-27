package com.ob11to.http.exception;

import com.ob11to.http.validator.Errors;
import lombok.Getter;

import java.util.List;

public class ValidatorException extends RuntimeException {

    @Getter
    private final List<Errors> errors;

    public ValidatorException(List<Errors> errors) {
        this.errors = errors;
    }
}
