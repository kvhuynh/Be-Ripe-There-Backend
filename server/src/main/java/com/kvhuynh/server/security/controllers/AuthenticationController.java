package com.kvhuynh.server.security.controllers;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kvhuynh.server.security.models.AuthenticationRequest;
import com.kvhuynh.server.security.models.AuthenticationResponse;
import com.kvhuynh.server.security.models.RegisterRequest;
import com.kvhuynh.server.security.services.AuthenticationService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request, BindingResult result) {

        AuthenticationResponse test = authService.register(request, result);
        if (result.hasErrors()) {
            AuthenticationResponse error = authService.generateError(result);
            return ResponseEntity.ok(error);
        }
        System.out.println("User has successfully registered");
        return ResponseEntity.ok(test);

    }

    @GetMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        System.out.println("User has been successfully authenticated");
        return ResponseEntity.ok(authService.authenticate(request));
    }

    @PostMapping("/refresh-token")
    public void refreshToken(
        HttpServletRequest request,
        HttpServletResponse response
    ) throws IOException {
        
      authService.refreshToken(request, response);
    }
}