package com.example.on_class_users.adapters.driven.jpa.mysql.adapter;

import com.example.on_class_users.adapters.driven.jpa.mysql.adapter.util.UserConstructor;
import com.example.on_class_users.adapters.driven.jpa.mysql.entity.RoleEntity;
import com.example.on_class_users.adapters.driven.jpa.mysql.entity.UserEntity;
import com.example.on_class_users.adapters.driven.jpa.mysql.exception.EmailAlreadyExistsException;
import com.example.on_class_users.adapters.driven.jpa.mysql.exception.RoleNotFoundException;
import com.example.on_class_users.adapters.driven.jpa.mysql.exception.UserAlreadyExistsException;
import com.example.on_class_users.adapters.driven.jpa.mysql.exception.WrongRoleException;
import com.example.on_class_users.adapters.driven.jpa.mysql.mapper.IUserEntityMapper;
import com.example.on_class_users.adapters.driven.jpa.mysql.repository.IRoleRepository;
import com.example.on_class_users.adapters.driven.jpa.mysql.repository.IUserRepository;
import com.example.on_class_users.domain.model.User;
import com.example.on_class_users.domain.spi.IUserPersistencePort;
import lombok.RequiredArgsConstructor;


import java.sql.SQLOutput;
import java.util.Objects;
import java.util.Optional;

@RequiredArgsConstructor
public class UserAdapter implements IUserPersistencePort {

    private final IUserRepository userRepository;
    private final IUserEntityMapper userEntityMapper;
    private final IRoleRepository roleRepository;
    private final UserConstructor userConstructors = new UserConstructor();

    @Override
    public void createSuperAdmin() {
        RoleEntity superRole = roleRepository.findByName("SUPER_ADMIN");
        if(!userRepository.existsByRole(superRole)){
            userRepository.save(userConstructors.superAdminBuilder(superRole));
        }

    }

    @Override
    public void saveAdminUser(User user) {
        UserEntity entity = userEntityMapper.toEntity(user);
        if(!Objects.equals(entity.getRole().getId(), roleRepository.findByName("ADMIN").getId())){
            throw new WrongRoleException();
        }
        UserEntity superAdmin = userRepository.findByName("Administrator");
        superAdmin.setEnabled(false);
        userRepository.save(superAdmin);
        createUser(user);
    }

    @Override
    public void saveTutorUser(User user) {
        UserEntity entity = userEntityMapper.toEntity(user);
        if(!Objects.equals(entity.getRole().getId(), roleRepository.findByName("TUTOR").getId())){
            throw new WrongRoleException();
        }
        createUser(user);
    }

    @Override
    public void saveStudentUser(User user) {
        UserEntity entity = userEntityMapper.toEntity(user);
        if(!Objects.equals(entity.getRole().getId(), roleRepository.findByName("STUDENT").getId())){
            throw new WrongRoleException();
        }
        createUser(user);
    }

    @Override
    public void saveUser(User user) {
        Optional<RoleEntity> roleEntity = roleRepository.findByNameIgnoreCase(user.getRole().getName());
        if(roleEntity.isEmpty()){
            throw new RoleNotFoundException();
        }
        createUser(user);
    }


    private void createUser(User user) {
        Optional<UserEntity> existingUser = userRepository.findById(user.getDni().trim());
        if (existingUser.isPresent()) {
            throw new UserAlreadyExistsException();
        }


        Optional<UserEntity> existingEmail = userRepository.findByEmailIgnoreCase(user.getEmail().trim());
        if (existingEmail.isPresent()) {
            throw new EmailAlreadyExistsException();
        }
        userRepository.save(userEntityMapper.toEntity(userConstructors.userBuilder(user)));
    }
}
