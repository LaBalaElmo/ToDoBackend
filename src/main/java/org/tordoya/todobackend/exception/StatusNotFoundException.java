package org.tordoya.todobackend.exception;

public class StatusNotFoundException extends RuntimeException {

    public StatusNotFoundException(String message) {
        super(message);
    }

    public StatusNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
