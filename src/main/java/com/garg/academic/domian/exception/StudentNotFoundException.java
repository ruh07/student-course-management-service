package com.garg.academic.domian.exception;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(Long id) {
        super("Could not found student Entity with id:" + id);
    }
}
