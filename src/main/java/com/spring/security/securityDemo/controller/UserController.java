package com.spring.security.securityDemo.controller;

import com.spring.security.securityDemo.dto.AuthRequest;
import com.spring.security.securityDemo.dto.UserModel;
import com.spring.security.securityDemo.service.JWTService;
import com.spring.security.securityDemo.service.UserDetailService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController {

    private final UserDetailService userDetailService;
    private final AuthenticationManager authenticationManager;
    private final JWTService jwtService;

/*
    @PostMapping("/saveUser")
    public String saveUser(
            @RequestBody UserModel user
    ) {
        String userId = userDetailService.saveUser(user);
        return userId;
    }
*/

    @PostMapping("/authenticate")
    public String authentication(@RequestBody AuthRequest authRequest) {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
        if (authentication.isAuthenticated())
            return jwtService.generateToken(authRequest.getUserName());
        else
            throw new UsernameNotFoundException("Invalid User Request");
    }

    @GetMapping("/getToken")
    public String getToken() {


            return jwtService.generateToken("test");
       }
}
