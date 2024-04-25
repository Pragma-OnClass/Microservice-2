package com.example.on_class_users.adapters.driven.jpa.mysql.repository;

import com.example.on_class_users.adapters.driven.jpa.mysql.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<UserEntity, String> {
    Optional<UserEntity> findByDniIgnoreCase(String dni);
    Optional<UserEntity> findByEmailIgnoreCase(String email);
}
