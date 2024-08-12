package org.tordoya.todobackend.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.tordoya.todobackend.domain.User;
import org.tordoya.todobackend.dto.UserRegisterRequestDTO;
import org.tordoya.todobackend.dto.UserResponseDTO;
import org.tordoya.todobackend.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserResponseDTO save(UserRegisterRequestDTO userRequest) {
        String encodedPassword = passwordEncoder.encode(userRequest.password());
        User user = new User(userRequest.username(), userRequest.email(), encodedPassword);
        userRepository.save(user);
        return new UserResponseDTO(user.getUsername());
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
