package com.narainox.ecommercebackendapplication.services;

import com.narainox.ecommercebackendapplication.dto.UserDto;
import com.narainox.ecommercebackendapplication.models.User;

public interface UserService {
    UserDto registerUser(UserDto userDto);
    User getUser(String username);
}
