package com.rishi.student_management.service;

import com.rishi.student_management.dto.AuthResponseDTO;
import com.rishi.student_management.dto.LoginRequestDTO;
import com.rishi.student_management.dto.RegisterRequestDTO;
import com.rishi.student_management.model.User;
import com.rishi.student_management.repository.UserRepository;
import com.rishi.student_management.security.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder,
                       AuthenticationManager authenticationManager,
                       JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    public String register(RegisterRequestDTO dto) {

        if(userRepository.existsByEmail(dto.getEmail())) {
            throw new RuntimeException("Email is already exists");
        }

        User user = new User();

        user.setName(dto.getName());
        user.setEmail(dto.getEmail());

        user.setPassword(passwordEncoder.encode(dto.getPassword()));

        user.setRole("USER");

        userRepository.save(user);

        return "User registered Successfully";
    }

    public AuthResponseDTO login(LoginRequestDTO dto) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                    dto.getEmail(),
                        dto.getPassword()
                )
        );

        String token = jwtService.generateToken(dto.getEmail());

        return new AuthResponseDTO(token);
    }
}
