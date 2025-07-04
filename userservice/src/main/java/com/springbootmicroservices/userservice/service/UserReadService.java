package com.springbootmicroservices.userservice.service;

import com.springbootmicroservices.userservice.model.user.response.UserResponse;

public interface UserReadService {
    UserResponse getUserById(final String emailId);
    //List<User> get(final ProductPagingRequest productPagingRequest);

}