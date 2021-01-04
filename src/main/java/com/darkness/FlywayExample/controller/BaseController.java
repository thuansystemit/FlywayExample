package com.darkness.FlywayExample.controller;

import com.darkness.FlywayExample.dto.ApiErrorDto;
import com.darkness.FlywayExample.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

@Controller
public class BaseController {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ApiErrorDto handleNotFoundException(NotFoundException ex) {
        return prepareResponseError(HttpStatus.NOT_FOUND, ex.getLocalizedMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiErrorDto handleValidationException(MethodArgumentNotValidException ex) {
        return prepareResponseError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage());
    }

    private ApiErrorDto prepareResponseError(HttpStatus status, String msg) {
        ApiErrorDto result = new ApiErrorDto(status);
        result.setMessage(msg);
        result.setTimestamp(LocalDateTime.now());
        return result;
    }
}
