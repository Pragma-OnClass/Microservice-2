package com.example.on_class_users.adapters.driven.jpa.mysql.mapper;

import com.example.on_class_users.adapters.driven.jpa.mysql.entity.UserEntity;
import com.example.on_class_users.domain.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IUserEntityMapper {
    UserEntity toEntity(User user);
    User toModel(UserEntity entity);
}
