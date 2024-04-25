package com.example.on_class_users.adapters.driving.http.mapper;

import com.example.on_class_users.adapters.driving.http.dto.request.AddRoleRequest;
import com.example.on_class_users.domain.model.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IRoleRequestMapper {
    @Mapping(target = "id", ignore = true)
    Role addRequestToRole(AddRoleRequest addRoleRequest);
}
