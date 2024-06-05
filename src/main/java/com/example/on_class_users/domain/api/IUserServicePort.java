package com.example.on_class_users.domain.api;

import com.example.on_class_users.domain.model.User;

public interface IUserServicePort {
    void createSuperAdmin();
    void saveAdminUser(User user);
    void saveTutorUser(User user);
    void saveStudentUser(User user);
    void saveUser(User user);
}
