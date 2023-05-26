package com.spring.security.securityDemo.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthRequest {
    private String userName;
    private String password;
}
