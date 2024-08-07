package com.narainox.ecommercebackendapplication.dto;

import jakarta.persistence.Id;
import lombok.Data;

@Data
public class RoleDto {
    private Integer id;
    private String name;
}
