package com.kvhuynh.server.models.auth;

import com.kvhuynh.server.models.enums.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    
    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private Role role;
    
    // private String confirmPassword;
}
