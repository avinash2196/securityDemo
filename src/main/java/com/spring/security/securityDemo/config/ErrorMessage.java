package com.spring.security.securityDemo.config;

import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Data
public class ErrorMessage {
private String message;
private HttpStatusCode httpStatusCode;

    ErrorMessage(String message,HttpStatusCode httpStatusCode){
        this.message=message;
        this.httpStatusCode=httpStatusCode;


    }
}
