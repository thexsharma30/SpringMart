package com.narainox.ecommercebackendapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class WishlistDto {
    private Integer id;
    private UserDto user;
    private ProductDto product;

}
