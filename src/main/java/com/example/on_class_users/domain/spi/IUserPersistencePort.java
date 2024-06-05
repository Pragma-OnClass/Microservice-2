package com.example.on_class_users.domain.spi;

import com.example.on_class_users.domain.model.User;

public interface IUserPersistencePort {
    void createSuperAdmin();
    void saveAdminUser(User user);
    void saveTutorUser(User user);
    void saveStudentUser(User user);
    void saveUser(User user);

}
