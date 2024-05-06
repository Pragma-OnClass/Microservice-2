package com.example.on_class_users.adapters.driven.jpa.mysql.adapter;

import com.example.on_class_users.adapters.driven.jpa.mysql.entity.UserEntity;
import com.example.on_class_users.adapters.driven.jpa.mysql.mapper.IUserEntityMapper;
import com.example.on_class_users.adapters.driven.jpa.mysql.repository.IUserRepository;
import com.example.on_class_users.domain.model.User;
import com.example.on_class_users.domain.spi.ILoginUserPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@RequiredArgsConstructor
public class LoginUserAdapter implements ILoginUserPersistencePort {
    private final IUserRepository userRepository;
    private final IUserEntityMapper userEntityMapper;

    private final AuthenticationManager authenticationManager;

    @Override
    public User loginUser(User user) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getEmail(),
                        user.getPassword()
                )
        );
        UserEntity userEntity = userRepository.findByEmailIgnoreCase(user.getEmail()).orElseThrow();
        return userEntityMapper.toModel(userEntity);
    }
}