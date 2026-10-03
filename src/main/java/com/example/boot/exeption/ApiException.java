package com.example.boot.exeption;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ApiException {
    private ErrorCodeEnum code;
    private String message;
}
