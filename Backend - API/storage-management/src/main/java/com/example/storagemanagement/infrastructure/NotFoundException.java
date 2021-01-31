package com.example.storagemanagement.infrastructure;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {

    private static final String MESSAGE = "not found %s";

    public NotFoundException(Class<?> clazz) {
        super(String.format(MESSAGE, clazz.getSimpleName()));
    }

}
