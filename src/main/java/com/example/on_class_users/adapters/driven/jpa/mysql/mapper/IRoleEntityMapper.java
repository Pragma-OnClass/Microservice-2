package com.example.on_class_users.adapters.driven.jpa.mysql.mapper;

import com.example.on_class_users.adapters.driven.jpa.mysql.entity.RoleEntity;
import com.example.on_class_users.domain.model.Role;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IRoleEntityMapper {
    RoleEntity toEntity(Role role);
    Role toModel(RoleEntity entity);
}
