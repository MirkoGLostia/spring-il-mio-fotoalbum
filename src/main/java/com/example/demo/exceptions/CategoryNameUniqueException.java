package com.example.demo.exceptions;

public class CategoryNameUniqueException extends RuntimeException{
    public CategoryNameUniqueException(String message) {
        super(message);
    }
}
