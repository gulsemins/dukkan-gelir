package com.dailywork.dukkan_gelir.service;

import com.dailywork.dukkan_gelir.dtos.AuthResponseDto;
import com.dailywork.dukkan_gelir.dtos.LoginRequestDto;
import com.dailywork.dukkan_gelir.dtos.RegisterRequestDto;
import com.dailywork.dukkan_gelir.dtos.UserResponseDto;
import com.dailywork.dukkan_gelir.entities.UserEntity;
import com.dailywork.dukkan_gelir.mapper.UserMapper;
import com.dailywork.dukkan_gelir.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserMapper userMapper;

    public UserResponseDto signup(RegisterRequestDto registerRequestDto) {
        if (userRepository.existsByUsername(registerRequestDto.getUsername())) {
            throw new IllegalArgumentException("Username already exists");
        }

        if (userRepository.findByEmail(registerRequestDto.getEmail()) != null) {
            throw new IllegalArgumentException("Email already exists");
        }

        UserEntity user = userMapper.toEntity(registerRequestDto);
        user.setPassword(bCryptPasswordEncoder.encode(registerRequestDto.getPassword()));

        UserEntity savedUser = userRepository.save(user);
        return userMapper.toRegisterResponseDto(savedUser);
    }

    public AuthResponseDto login(LoginRequestDto loginRequestDto) {
        Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequestDto.getUsername(),
                        loginRequestDto.getPassword()
                )
        );

        if (authenticate.isAuthenticated()) {
            String token = jwtService.generateToken(loginRequestDto.getUsername());
            return new AuthResponseDto(token);
        }

        throw new RuntimeException("Invalid login credentials");
    }

    public UserEntity getUserById(String id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public UserEntity getUserByUsername(String username) {
        UserEntity user = userRepository.findByUsername(username);
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        return user;
    }
}