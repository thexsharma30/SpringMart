package com.narainox.ecommercebackendapplication.dto;

import com.narainox.ecommercebackendapplication.models.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {
    private String username;
    private String email;
    private String password;
    private Set<RoleDto> roles=new HashSet<>();

}
