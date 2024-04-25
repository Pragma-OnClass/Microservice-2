package com.example.on_class_users.adapters.driving.http.dto.request;

import com.example.on_class_users.adapters.driving.http.util.MessageConstants;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@Getter
public class AddRoleRequest {
    @NotEmpty(message = MessageConstants.FIELD_NAME_NULL_MESSAGE)
    private final String name;
    @NotBlank(message = MessageConstants.FIELD_DESCRIPTION_NULL_MESSAGE)
    private final String description;
}
