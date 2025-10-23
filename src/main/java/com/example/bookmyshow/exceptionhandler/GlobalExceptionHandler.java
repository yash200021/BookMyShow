package com.example.bookmyshow.exceptionhandler;

import com.example.bookmyshow.exceptions.ShowSeatNotAvailableException;
import com.example.bookmyshow.exceptions.UserNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UserNotFoundException.class)
    public String handleUserNotFoundException() {
        return "User not found!";
    }

    @ExceptionHandler(ShowSeatNotAvailableException.class)
    public String handleShowSeatNotAvailableException() {
        return "Show seat not available!";
    }
}
