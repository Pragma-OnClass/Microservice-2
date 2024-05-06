package com.example.on_class_users.adapters.driving.http.dto.request;

import com.example.on_class_users.adapters.driving.http.util.MessageConstants;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@Getter
public class LoginUserRequest {
    @NotBlank(message = MessageConstants.FIELD_EMAIL_NULL_MESSAGE)
    private final String email;
    @NotBlank(message = MessageConstants.FIELD_PASSWORD_NULL_MESSAGE)
    private final String password;
}
