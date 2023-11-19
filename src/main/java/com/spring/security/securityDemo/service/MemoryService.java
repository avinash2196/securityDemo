package com.spring.security.securityDemo.service;

import com.spring.security.securityDemo.model.User;

import java.util.Optional;

public interface MemoryService {
    Optional<User> findUserByEmail(String email);
}
