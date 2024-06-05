package com.example.on_class_users.adapters.driving.http.mapper;

import com.example.on_class_users.adapters.driving.http.dto.request.LoginUserRequest;
import com.example.on_class_users.domain.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ILoginUserRequestMapper {
    User addRequestToLoginUser(LoginUserRequest loginUserRequest);
}
