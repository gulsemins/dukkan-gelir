package com.dailywork.dukkan_gelir.controllers;

import com.dailywork.dukkan_gelir.dtos.AuthResponseDto;
import com.dailywork.dukkan_gelir.dtos.LoginRequestDto;
import com.dailywork.dukkan_gelir.dtos.RegisterRequestDto;
import com.dailywork.dukkan_gelir.dtos.UserResponseDto;
import com.dailywork.dukkan_gelir.repository.UserRepository;
import com.dailywork.dukkan_gelir.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController {
    private final UserRepository userRepository;
    private final UserService userService;

    @PostMapping("/signup")
    public UserResponseDto signup(@Valid @RequestBody RegisterRequestDto registerRequestDto){
        //return userRepository.save(user);

        return userService.signup(registerRequestDto);

    }
    @PostMapping("/login")
    public AuthResponseDto login(@RequestBody LoginRequestDto loginRequestDto){

        return userService.login(loginRequestDto);

    }
}
