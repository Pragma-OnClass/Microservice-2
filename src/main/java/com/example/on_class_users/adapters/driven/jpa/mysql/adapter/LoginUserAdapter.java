package com.example.on_class_users.adapters.driven.jpa.mysql.adapter;


import com.example.on_class_users.adapters.driven.jpa.mysql.exception.UserDisabledException;
import com.example.on_class_users.adapters.driven.jpa.mysql.exception.WrongPasswordException;
import com.example.on_class_users.adapters.driven.jpa.mysql.exception.UserNotFoundException;
import com.example.on_class_users.adapters.driven.jpa.mysql.repository.IUserRepository;
import com.example.on_class_users.adapters.security.jwt.JwtUtils;
import com.example.on_class_users.domain.model.BodyAuth;
import com.example.on_class_users.domain.model.User;
import com.example.on_class_users.domain.spi.ILoginUserPersistencePort;
import lombok.RequiredArgsConstructor;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;


@RequiredArgsConstructor
public class LoginUserAdapter implements ILoginUserPersistencePort {

    private final JwtUtils jwtUtils;
    private final PasswordEncoder passwordEncoder;
    private final IUserRepository userRepository;


    @Override
    public BodyAuth loginUser(User user) {
        String username = user.getEmail();
        String password = user.getPassword();

        Authentication authentication = this.authenticate(username, password);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String accessToken = jwtUtils.createToken(authentication);

        return new BodyAuth(username, "User successfully logged in", accessToken, true);
    }

    public Authentication authenticate (String username, String password){
        UserDetails userDetails = userRepository.findByEmailIgnoreCase(username).orElseThrow(UserNotFoundException::new);
        if(!passwordEncoder.matches(password, userDetails.getPassword())){
            throw new WrongPasswordException();
        }
        if (!userDetails.isEnabled()){
            throw new UserDisabledException();
        }
        return new UsernamePasswordAuthenticationToken(username, userDetails.getPassword(), userDetails.getAuthorities());
    }

}