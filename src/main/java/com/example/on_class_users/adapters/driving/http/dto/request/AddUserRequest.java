package com.example.on_class_users.adapters.driving.http.dto.request;

import com.example.on_class_users.adapters.driving.http.util.MessageConstants;
import com.example.on_class_users.domain.model.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@AllArgsConstructor
@Getter
public class AddUserRequest {
    @NotBlank(message = MessageConstants.FIELD_DNI_NULL_MESSAGE)
    @Pattern(regexp = "^\\d+$", message = MessageConstants.FIELD_DNI_ONLY_NUMBERS_MESSAGE)
    private final String dni;

    @NotBlank(message = MessageConstants.FIELD_NAME_NULL_MESSAGE)
    private final String name;

    @NotBlank(message = MessageConstants.FIELD_LAST_NAME_NULL_MESSAGE)
    private final String lastname;

    @NotBlank(message = MessageConstants.FIELD_CELLPHONE_NULL_MESSAGE)
    @Pattern(regexp = "^\\d+$", message = MessageConstants.FIELD_CELLPHONE_ONLY_NUMBERS_MESSAGE)
    private final String cellphone;

    @NotNull(message = MessageConstants.FIELD_ROLE_NULL_MESSAGE)
    private final Role role;

    @NotBlank(message = MessageConstants.FIELD_EMAIL_NULL_MESSAGE)
    @Email(message = MessageConstants.FIELD_EMAIL_IS_NOT_EMAIL_MESSAGE)
    private final String email;

    @NotBlank(message = MessageConstants.FIELD_PASSWORD_NULL_MESSAGE)
    private final String password;
}
