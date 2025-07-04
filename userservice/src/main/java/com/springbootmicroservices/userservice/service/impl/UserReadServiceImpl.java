package com.springbootmicroservices.userservice.service.impl;

import com.springbootmicroservices.userservice.exception.UserNotFoundException;
import com.springbootmicroservices.userservice.model.user.entity.UserEntity;
import com.springbootmicroservices.userservice.model.user.mapper.UserEntityToUserResponseMapper;
import com.springbootmicroservices.userservice.model.user.response.UserResponse;
import com.springbootmicroservices.userservice.repository.UserRepository;
import com.springbootmicroservices.userservice.service.UserReadService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserReadServiceImpl implements UserReadService {

    private final UserRepository userRepository;

    private final UserEntityToUserResponseMapper userEntityToUserResponseMapper = UserEntityToUserResponseMapper.initialize();

    private final PasswordEncoder passwordEncoder =new BCryptPasswordEncoder();
    @Override
    public UserResponse getUserById(String emailId) {
        final UserEntity userEntityFromDB = userRepository
                .findUserEntityByEmail(emailId)
                .orElseThrow(() -> new UserNotFoundException("With given EmailId = " + emailId));
        //passwordEncoder.matches()
        UserResponse userResponse= userEntityToUserResponseMapper.map(userEntityFromDB);
        return userResponse;
    }
}
