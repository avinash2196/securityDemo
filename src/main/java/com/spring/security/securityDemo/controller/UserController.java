package com.spring.security.securityDemo.controller;

import com.spring.security.securityDemo.dto.UserModel;
import com.spring.security.securityDemo.service.UserDetailService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController {

    private final UserDetailService userDetailService;

    @PostMapping("/saveUser")
    public String saveUser(
            @RequestBody UserModel user
    ) {
        String userId = userDetailService.saveUser(user);
        return userId;
    }
}
