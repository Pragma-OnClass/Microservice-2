package com.example.on_class_users.adapters.driving.http.dto.response;

import com.example.on_class_users.domain.model.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public class LoginUserResponse {
    private final String dni;
    private final String name;
    private final String lastname;
    private final String email;
    private final Role role;
}
