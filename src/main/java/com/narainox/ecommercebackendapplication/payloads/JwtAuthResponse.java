package com.narainox.ecommercebackendapplication.payloads;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JwtAuthResponse {
    private String token;
    private String username;
}
