package com.example.on_class_users.configuration;


public class Constants {
    private Constants() {
        throw new IllegalStateException("Utility class");
    }
    public static final String EMAIL_ALREADY_EXISTS_EXCEPTION_MESSAGE = "This email already exists";
    public static final String ROLE_ALREADY_EXISTS_EXCEPTION_MESSAGE = "This role already exists";
    public static final String USER_ALREADY_EXISTS_EXCEPTION_MESSAGE = "This user already exists";
    public static final String USER_NOT_FOUND_EXCEPTION_MESSAGE = "This user not found";
    public static final String WRONG_ROLE_EXCEPTION_MESSAGE = "You do not have permissions to create the user with the entered role";
    public static final String ROLE_NOT_FOUND_EXCEPTION_MESSAGE = "this user role does not exist";
}
