package com.spring.security.securityDemo.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.IOException;

@ControllerAdvice
public class MyControllerAdvice {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.FAILED_DEPENDENCY)
 @ResponseBody
    public ErrorMessage handleException(Exception exception) {

    return new ErrorMessage("error",HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorMessage handleMissingRequestParams(MissingServletRequestParameterException exception) {

        return new ErrorMessage("error",HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler({ InsufficientAuthenticationException.class })
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public ErrorMessage handleAuthenticationException( InsufficientAuthenticationException ex) throws IOException {

      return new ErrorMessage(
                "Authentication failed at controller advice",HttpStatus.UNAUTHORIZED);

    }

}
