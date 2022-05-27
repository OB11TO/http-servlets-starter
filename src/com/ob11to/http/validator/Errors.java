package com.ob11to.http.validator;

import lombok.Value;

@Value(staticConstructor = "of")
public class Errors {
    String code;
    String massage;
}
