package com.example.on_class_users.adapters.driven.jpa.mysql.adapter;

import com.example.on_class_users.adapters.driven.jpa.mysql.entity.UserEntity;
import com.example.on_class_users.adapters.driven.jpa.mysql.exception.EmailAlreadyExistsException;
import com.example.on_class_users.adapters.driven.jpa.mysql.exception.UserAlreadyExistsException;
import com.example.on_class_users.adapters.driven.jpa.mysql.mapper.IUserEntityMapper;
import com.example.on_class_users.adapters.driven.jpa.mysql.repository.IUserRepository;
import com.example.on_class_users.domain.model.User;
import com.example.on_class_users.domain.spi.IUserPersistencePort;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class UserAdapter implements IUserPersistencePort {
    private final IUserRepository userRepository;
    private final IUserEntityMapper userEntityMapper;

    @Override
    public void saveUser(User user) {
        Optional<UserEntity> existingUser = userRepository.findByDniIgnoreCase(user.getDni().trim());
        if (existingUser.isPresent()) {
            throw new UserAlreadyExistsException();
        }

        Optional<UserEntity> existingEmail = userRepository.findByEmailIgnoreCase(user.getEmail().trim());
        if (existingEmail.isPresent()) {
            throw new EmailAlreadyExistsException();
        }

        userRepository.save(userEntityMapper.toEntity(new User(
                user.getDni().trim(),
                user.getName().trim().toUpperCase(),
                user.getLastname().trim().toUpperCase(),
                user.getCellphone().trim(),
                user.getRole(),
                user.getEmail().trim().toLowerCase(),
                user.getPassword()
        )));
    }
}
