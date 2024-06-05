package com.example.on_class_users.adapters.driven.jpa.mysql.adapter.util;

import lombok.Getter;

@Getter
public enum RoleEnum {
    SUPER_ADMIN("SUPER_ADMIN", "All permissions"),
    ADMIN("ADMIN", "This role has all permissions except creating another admin"),
    TUTOR("TUTOR", "This role only allows to create student users"),
    STUDENT("STUDENT", "This role allows to consult information");

    private final String name;
    private final String description;

    RoleEnum(String name, String description) {
        this.name = name;
        this.description = description;
    }

}
