package com.example.demo.exceptions;

public class UserEmailAlreadyExistException extends RuntimeException{
    public UserEmailAlreadyExistException(String message) {
        super(message);
    }
}
