package com.example.choice_platform_api.utils;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;


@Data
public class GenericResponse<T> {

    private HttpStatus status;
    private boolean isSuccess;
    private String message;
    private T data;
    private List<T> dataList;

    public GenericResponse() {}

    public GenericResponse(HttpStatus status,boolean isSuccess, String msg, T data) {
        this.status = status;
        this.isSuccess = isSuccess;
        this.message = msg;
        this.data = data;
    }
}
