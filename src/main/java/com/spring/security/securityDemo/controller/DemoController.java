package com.spring.security.securityDemo.controller;

import com.spring.security.securityDemo.service.DemoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class DemoController {

    private final DemoService demoService;

    @GetMapping("/")
    public String hello() {
        return demoService.sayHello();
    }
}
