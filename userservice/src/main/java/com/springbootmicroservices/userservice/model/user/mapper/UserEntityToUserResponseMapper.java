package com.springbootmicroservices.userservice.model.user.mapper;

import com.springbootmicroservices.userservice.model.common.mapper.BaseMapper;
import com.springbootmicroservices.userservice.model.user.entity.UserEntity;
import com.springbootmicroservices.userservice.model.user.response.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserEntityToUserResponseMapper extends BaseMapper<UserEntity, UserResponse> {

    @Override
    UserResponse map(UserEntity source);

    static UserEntityToUserResponseMapper initialize() {
        return Mappers.getMapper(UserEntityToUserResponseMapper.class);
    }




}
