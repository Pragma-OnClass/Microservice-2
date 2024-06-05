package com.example.on_class_users.domain.api;

import com.example.on_class_users.domain.model.BodyAuth;
import com.example.on_class_users.domain.model.User;

public interface ILoginUserServicePort {
    BodyAuth loginUser(User user);
}
