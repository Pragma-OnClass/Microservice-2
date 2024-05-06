package com.example.on_class_users.adapters.driving.http.mapper;

import com.example.on_class_users.adapters.driving.http.dto.response.LoginUserResponse;
import com.example.on_class_users.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ILoginUserResponseMapper {
    @Mapping(target = "role", source = "user.role")
    LoginUserResponse toLoginUserResponse(User user);
}
