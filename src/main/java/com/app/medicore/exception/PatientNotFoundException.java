package com.app.medicore.exception;

public class PatientNotFoundException
        extends RuntimeException {

    public PatientNotFoundException(String message) {
        super(message);
    }
}