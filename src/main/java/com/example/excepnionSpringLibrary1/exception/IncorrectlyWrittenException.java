package com.example.excepnionSpringLibrary1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class IncorrectlyWrittenException extends RuntimeException {
    public IncorrectlyWrittenException() {
    }

    public IncorrectlyWrittenException(String message) {
        super(message);
    }

    public IncorrectlyWrittenException(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectlyWrittenException(Throwable cause) {
        super(cause);
    }

    public IncorrectlyWrittenException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
