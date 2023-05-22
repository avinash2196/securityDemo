package com.spring.security.securityDemo.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
@Builder
public class UserModel {

    private String firstName;

    private String lastName;

    private String password;

    private String email;

    private List<String> roles;
}
