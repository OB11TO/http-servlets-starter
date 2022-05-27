package com.ob11to.http.validator;

public interface Validator<T> {

    ValidatorResult isValid(T object);
}
