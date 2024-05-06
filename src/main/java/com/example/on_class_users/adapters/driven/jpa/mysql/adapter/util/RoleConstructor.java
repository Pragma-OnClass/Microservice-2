package com.example.on_class_users.adapters.driven.jpa.mysql.adapter.util;

import com.example.on_class_users.adapters.driven.jpa.mysql.entity.RoleEntity;
import com.example.on_class_users.adapters.driven.jpa.mysql.repository.IRoleRepository;
import com.example.on_class_users.domain.model.Role;

import java.util.List;

public class RoleConstructor {

    public RoleEntity defaultRoleBuilder(String roleName){
        return RoleEntity.fromEnum(RoleEnum.valueOf(roleName));
    }
    public Role roleBuilder(Role role) {
        return new Role(
                role.getId(),
                role.getName().trim().toUpperCase(),
                role.getDescription()
        );
    }
}
