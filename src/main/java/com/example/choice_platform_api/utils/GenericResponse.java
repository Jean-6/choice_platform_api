package com.example.choice_platform_api.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenericResponse<T> {

    private int status;
    private boolean isSuccess;
    private String message;
    private T data;
    private List<T> dataList;
}
