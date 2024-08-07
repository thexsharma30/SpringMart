package com.narainox.ecommercebackendapplication.services.impl;

import com.narainox.ecommercebackendapplication.dto.UserDto;
import com.narainox.ecommercebackendapplication.models.Role;
import com.narainox.ecommercebackendapplication.models.User;
import com.narainox.ecommercebackendapplication.repository.RoleRepository;
import com.narainox.ecommercebackendapplication.repository.UserRepository;
import com.narainox.ecommercebackendapplication.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public User getUser(String username)
    {
        return userRepository.findByUsername(username).get();
    }

    @Override
    public UserDto registerUser(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        //encode the password
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        //Roles
        Role role = roleRepository.findById(502).get();
        user.getRoles().add(role);
        User save = userRepository.save(user);
        return modelMapper.map(save, UserDto.class);
    }
}
