package com.example.on_class_users.adapters.driven.jpa.mysql.entity;

import com.example.on_class_users.adapters.driven.jpa.mysql.adapter.util.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "role")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    public static RoleEntity fromEnum(RoleEnum roleEnum) {
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setName(roleEnum.getName());
        roleEntity.setDescription(roleEnum.getDescription());
        return roleEntity;
    }
}
