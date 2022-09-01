package com.example.posttestpln.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponDto<T> {
    private Boolean success;
    private String status;
    private String message;
    private T data;
}
