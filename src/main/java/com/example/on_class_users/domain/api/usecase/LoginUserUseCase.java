package com.example.on_class_users.domain.api.usecase;

import com.example.on_class_users.domain.api.ILoginUserServicePort;
import com.example.on_class_users.domain.model.BodyAuth;
import com.example.on_class_users.domain.model.User;
import com.example.on_class_users.domain.spi.ILoginUserPersistencePort;

public class LoginUserUseCase implements ILoginUserServicePort {
    private final ILoginUserPersistencePort loginUserPersistencePort;

    public LoginUserUseCase(ILoginUserPersistencePort loginUserPersistencePort) {
        this.loginUserPersistencePort = loginUserPersistencePort;
    }

    @Override
    public BodyAuth loginUser(User user) {
        return loginUserPersistencePort.loginUser(user);
    }
}
