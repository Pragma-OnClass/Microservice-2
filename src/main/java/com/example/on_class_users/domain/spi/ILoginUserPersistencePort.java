package com.example.on_class_users.domain.spi;

import com.example.on_class_users.domain.model.BodyAuth;
import com.example.on_class_users.domain.model.User;

public interface ILoginUserPersistencePort {
    BodyAuth loginUser(User user);
}
