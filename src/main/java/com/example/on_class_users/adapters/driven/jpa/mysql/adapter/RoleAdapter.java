package com.example.on_class_users.adapters.driven.jpa.mysql.adapter;

import com.example.on_class_users.adapters.driven.jpa.mysql.entity.RoleEntity;
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

    @Override
    public void saveRol(Role role) {
        Optional<RoleEntity> existingRole = roleRepository.findByNameIgnoreCase(role.getName().trim());
        if (existingRole.isPresent()) {
            throw new RoleAlreadyExistsException();
        }

        roleRepository.save(roleEntityMapper.toEntity(new Role(
           role.getId(),
           role.getName().trim().toUpperCase(),
           role.getDescription()
        )));
    }
}
