package com.example.on_class_users.adapters.driven.jpa.mysql.adapter;

import com.example.on_class_users.adapters.driven.jpa.mysql.adapter.util.RoleConstructor;
import com.example.on_class_users.adapters.driven.jpa.mysql.exception.RoleAlreadyExistsException;
import com.example.on_class_users.adapters.driven.jpa.mysql.mapper.IRoleEntityMapper;
import com.example.on_class_users.adapters.driven.jpa.mysql.repository.IRoleRepository;
import com.example.on_class_users.domain.model.Role;
import com.example.on_class_users.domain.spi.IRolePersistencePort;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class RoleAdapter implements IRolePersistencePort {
    private final IRoleRepository roleRepository;
    private final IRoleEntityMapper roleEntityMapper;
    private final RoleConstructor roleConstructor= new RoleConstructor();

    @Override
    public void createDefaultRole(String roleName) {
        if(!isExists(roleName)){
            roleRepository.save(roleConstructor.defaultRoleBuilder(roleName));
        }
    }

    @Override
    public void saveRol(Role role) {
        if (isExists(role.getName().trim())) {
            throw new RoleAlreadyExistsException();
        }
        roleRepository.save(roleEntityMapper.toEntity(roleConstructor.roleBuilder(role)));
    }

    private boolean isExists(String roleName) {
        return roleRepository.findByNameIgnoreCase(roleName).isPresent();
    }
}
