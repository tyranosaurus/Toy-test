package com.midasit.bungae.exception;

public class MaxBoardOverflowException extends RuntimeException {
    public MaxBoardOverflowException() {
        super();
    }

    public MaxBoardOverflowException(String message) {
        super(message);
    }

    public MaxBoardOverflowException(String message, Throwable cause) {
        super(message, cause);
    }
}
