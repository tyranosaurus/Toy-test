package com.midasit.bungae.exception;

public class NotEqualWriterException extends RuntimeException {
    public NotEqualWriterException() {
        super();
    }

    public NotEqualWriterException(String message) {
        super(message);
    }

    public NotEqualWriterException(String message, Throwable cause) {
        super(message, cause);
    }
}
