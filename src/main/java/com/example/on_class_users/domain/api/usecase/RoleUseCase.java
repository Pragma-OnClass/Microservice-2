package com.example.on_class_users.domain.api.usecase;

import com.example.on_class_users.domain.api.IRoleServicePort;
import com.example.on_class_users.domain.model.Role;
import com.example.on_class_users.domain.spi.IRolePersistencePort;

public class RoleUseCase implements IRoleServicePort {
    private IRolePersistencePort rolePersistencePort;

    public RoleUseCase(IRolePersistencePort rolePersistencePort) {
        this.rolePersistencePort = rolePersistencePort;
    }

    @Override
    public void createDefaultRole(String roleName) {
        rolePersistencePort.createDefaultRole(roleName);
    }

    @Override
    public void saveRole(Role role) {
        rolePersistencePort.saveRol(role);
    }
}
