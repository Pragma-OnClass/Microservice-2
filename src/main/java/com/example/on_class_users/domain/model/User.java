package com.example.on_class_users.domain.model;

public class User {
    private final String dni;
    private final String name;
    private final String lastname;
    private final String cellphone;
    private final Role role;
    private final String email;
    private final String password;

    public User(String dni, String name, String lastname, String cellphone, Role role, String email, String password) {
        this.dni = dni;
        this.name = name;
        this.lastname = lastname;
        this.cellphone = cellphone;
        this.role = role;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getCellphone() {
        return cellphone;
    }

    public String getDni() {
        return dni;
    }

    public Role getRole() {
        return role;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }


}
