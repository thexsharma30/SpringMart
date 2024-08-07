package com.narainox.ecommercebackendapplication.payloads;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class APIResponse<T> {
    private T data;
    private String message;
}
