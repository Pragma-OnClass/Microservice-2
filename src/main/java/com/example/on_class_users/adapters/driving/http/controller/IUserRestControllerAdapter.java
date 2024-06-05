package com.example.on_class_users.adapters.driving.http.controller;

import com.example.on_class_users.adapters.driving.http.dto.request.AddUserRequest;
import com.example.on_class_users.adapters.driving.http.mapper.IUserRequestMapper;
import com.example.on_class_users.domain.api.IUserServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@PreAuthorize("denyAll()")
public class IUserRestControllerAdapter {
    private final IUserServicePort userServicePort;
    private final IUserRequestMapper userRequestMapper;

    @PostMapping("/admin")
    @PreAuthorize("hasRole('SUPER_ADMIN')")
    public ResponseEntity<Void> addUserAdmin(@Valid @RequestBody AddUserRequest request){
        userServicePort.saveAdminUser(userRequestMapper.addRequestToUser(request));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/tutor")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> addUserTutor(@Valid @RequestBody AddUserRequest request){
        userServicePort.saveTutorUser(userRequestMapper.addRequestToUser(request));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/student")
    @PreAuthorize("hasAnyRole('ADMIN', 'TUTOR')")
    public ResponseEntity<Void> addUserStudent(@Valid @RequestBody AddUserRequest request){
        userServicePort.saveStudentUser(userRequestMapper.addRequestToUser(request));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/createUser")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> addUserByRol(@Valid @RequestBody AddUserRequest request){
        userServicePort.saveUser(userRequestMapper.addRequestToUser(request));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
