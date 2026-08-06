package com.rishi.student_management.service;

import com.rishi.student_management.dto.RegisterRequestDTO;
import com.rishi.student_management.model.User;
import com.rishi.student_management.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
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
}
