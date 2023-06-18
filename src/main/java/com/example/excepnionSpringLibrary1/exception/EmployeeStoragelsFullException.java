package com.example.excepnionSpringLibrary1.exception;

public class EmployeeStoragelsFullException extends RuntimeException {
    public EmployeeStoragelsFullException() {
    }

    public EmployeeStoragelsFullException(String message) {
        super(message);
    }

    public EmployeeStoragelsFullException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmployeeStoragelsFullException(Throwable cause) {
        super(cause);
    }

    public EmployeeStoragelsFullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
