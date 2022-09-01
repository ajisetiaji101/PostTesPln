package com.example.posttestpln.utils;

import com.example.posttestpln.dto.ResponDto;
import org.springframework.http.HttpStatus;

public class ResponseUtil {
    public static <T>ResponDto<T> responDtoSucces(T data, String message) {
        return new ResponDto<>(
                true,
                HttpStatus.OK.toString(),
                message,
                data
        );
    }

    public static <T> ResponDto<T> responseDtoFailed(T data, String errorMessage) {
        return new ResponDto<>(
                false,
                HttpStatus.OK.toString(),
                errorMessage,
                data
        );
    }

    public static <T> ResponDto<T> responseDtoFailed(T data, String errorMessage, HttpStatus httpStatus) {
        return new ResponDto<>(
                false,
                httpStatus.toString(),
                errorMessage,
                data
        );
    }
}
