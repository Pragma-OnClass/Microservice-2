package com.example.on_class_users.adapters.driving.http.controller;

import com.example.on_class_users.adapters.driving.http.dto.request.LoginUserRequest;
import com.example.on_class_users.adapters.driving.http.dto.response.LoginUserResponse;
import com.example.on_class_users.adapters.driving.http.mapper.ILoginUserRequestMapper;
import com.example.on_class_users.adapters.driving.http.mapper.ILoginUserResponseMapper;
import com.example.on_class_users.domain.api.ILoginUserServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@PreAuthorize("denyAll()")
public class IRestLoginControllerAdapter {
    private final ILoginUserServicePort loginUserServicePort;
    private final ILoginUserRequestMapper loginUserRequestMapper;
    private final ILoginUserResponseMapper loginUserResponseMapper;
    @PostMapping("/login")
    @PreAuthorize("permitAll()")
    public ResponseEntity<LoginUserResponse> loginUser(@Valid @RequestBody LoginUserRequest request){
        return ResponseEntity.ok(loginUserResponseMapper.toLoginUserResponse(
                loginUserServicePort.loginUser(loginUserRequestMapper.addRequestToLoginUser(request))));
    }
}
