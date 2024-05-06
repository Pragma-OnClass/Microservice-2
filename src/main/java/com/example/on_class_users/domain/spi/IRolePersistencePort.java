package com.example.on_class_users.domain.spi;

import com.example.on_class_users.domain.model.Role;

public interface IRolePersistencePort {
    void createDefaultRole(String roleName);
    void saveRol(Role role);
}
