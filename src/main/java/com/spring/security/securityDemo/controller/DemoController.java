package com.spring.security.securityDemo.controller;

import com.spring.security.securityDemo.service.DemoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class DemoController {

    private final DemoService demoService;

    @Operation(security = @SecurityRequirement(name = "Bearer Authentication"))
    @GetMapping(value = "/hello",produces = MediaType.APPLICATION_JSON_VALUE)
    public String hello() {
        return demoService.sayHello();
    }

    @GetMapping("/WithoutAuth")
    public String helloWithoutAuth() {
        return demoService.sayHelloWithoutAuth();
    }
}
