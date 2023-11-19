package com.spring.security.securityDemo.service;

import com.spring.security.securityDemo.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemoryServiceImpl implements  MemoryService{
    private final PasswordEncoder passwordEncoder;
    @Override
    public Optional<User> findUserByEmail(String email) {
        String encodedPassword = passwordEncoder.encode("test");
        User user =User.builder().firstName("test").lastName("test")
                .password(encodedPassword).email("test").roles(Arrays.asList("USER","ADMIN")).build();
        return Optional.of(user);
    }
}
