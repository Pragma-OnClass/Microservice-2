package com.example.on_class_users.domain.spi;

import com.example.on_class_users.domain.model.User;

public interface IUserPersistencePort {
    void saveUser(User user);
}
