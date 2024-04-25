package com.example.on_class_users.domain.api;

import com.example.on_class_users.domain.model.User;

public interface IUserServicePort {
    void saveUser(User user);
}
