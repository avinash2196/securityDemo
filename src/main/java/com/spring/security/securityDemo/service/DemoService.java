package com.spring.security.securityDemo.service;

import org.springframework.stereotype.Service;

@Service
public class DemoService {
    public String sayHello() {
        return "hello from Service";
    }

    public String sayHelloWithoutAuth() {
        return "hello without Auth";
    }
}
