package com.narainox.ecommercebackendapplication.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Email {
    private String recipient;
    private String subject;
    private String message;
    private MultipartFile attachment;
}
