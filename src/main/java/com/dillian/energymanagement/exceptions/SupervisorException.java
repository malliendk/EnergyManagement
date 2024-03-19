package com.dillian.energymanagement.exceptions;

public class SupervisorException extends RuntimeException {

    public SupervisorException(String message) {
        super(message);
    }

    public static final String NOT_FOUND_EXCEPTION = "Supervisor with id %s not found";
}
