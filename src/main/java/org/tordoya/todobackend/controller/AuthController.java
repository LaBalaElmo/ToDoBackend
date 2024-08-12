package org.tordoya.todobackend.controller;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tordoya.todobackend.authentication.services.JwtService;
import org.tordoya.todobackend.dto.JwtResponseDTO;
import org.tordoya.todobackend.dto.LoginRequestDTO;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthController(JwtService jwtService, AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public JwtResponseDTO login(@RequestBody LoginRequestDTO login) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login.email(), login.password()));
        if(authentication.isAuthenticated()){
            return new JwtResponseDTO(jwtService.generateToken(login.email()));
        } else {
            throw new UsernameNotFoundException("invalid user request..!!");
        }
    }
}
