package com.example.on_class_users.domain.api;

import com.example.on_class_users.domain.model.Role;

public interface IRoleServicePort {
    void createDefaultRole(String roleName);
    void saveRole (Role role);
}

