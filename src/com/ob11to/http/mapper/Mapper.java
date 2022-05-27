package com.ob11to.http.mapper;

public interface Mapper<F,T> {

    T mapFrom(F object);
}
