package com.giabao.Errors;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class StudentNotFoundException extends RuntimeException {
    private static final long serialVersionID = 1L;

    public StudentNotFoundException(String mess) {
        super(mess);
    }
}
