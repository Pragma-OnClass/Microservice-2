package com.example.on_class_users.adapters.driven.jpa.mysql.adapter.util;

import com.example.on_class_users.adapters.driven.jpa.mysql.entity.RoleEntity;
import com.example.on_class_users.adapters.driven.jpa.mysql.entity.UserEntity;
import com.example.on_class_users.domain.model.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserConstructor {

    public UserEntity superAdminBuilder(RoleEntity superRole){
        UserEntity adminUser = new UserEntity();
        adminUser.setDni("0");
        adminUser.setName("Administrator");
        adminUser.setLastname("");
        adminUser.setCellphone("0");
        adminUser.setEmail("admin");
        adminUser.setPassword("$2a$10$xRksfvqf7P8lw69frISiWeR0qj1kchXjdTK/4E7cC8TUbuMLNEiYS"); //7Qn2Xf8Ky3Zr
        adminUser.setRole(superRole);

        return adminUser;
    }
    public User userBuilder(User user) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return new User(
                user.getDni().trim(),
                user.getName().trim().toUpperCase(),
                user.getLastname().trim().toUpperCase(),
                user.getCellphone().trim(),
                user.getRole(),
                user.getEmail().trim().toLowerCase(),
                passwordEncoder.encode(user.getPassword()));
    }

}

