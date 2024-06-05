package com.example.on_class_users.adapters.driving.http.mapper;

import com.example.on_class_users.adapters.driving.http.dto.response.LoginUserResponse;
import com.example.on_class_users.domain.model.BodyAuth;

import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface ILoginUserResponseMapper {
    LoginUserResponse toLoginUserResponse(BodyAuth bodyAuth);
}
