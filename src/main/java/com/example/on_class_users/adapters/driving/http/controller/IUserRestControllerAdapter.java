package com.example.on_class_users.adapters.driving.http.controller;

import com.example.on_class_users.adapters.driving.http.dto.request.AddUserRequest;
import com.example.on_class_users.adapters.driving.http.mapper.IUserRequestMapper;
import com.example.on_class_users.domain.api.IUserServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class IUserRestControllerAdapter {
    private final IUserServicePort userServicePort;
    private final IUserRequestMapper userRequestMapper;

    @PostMapping("/")
    public ResponseEntity<Void> addUser(@Valid @RequestBody AddUserRequest request){
        userServicePort.saveUser(userRequestMapper.addRequestToUser(request));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
