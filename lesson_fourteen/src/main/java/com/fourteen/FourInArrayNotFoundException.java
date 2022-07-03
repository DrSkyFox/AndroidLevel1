package com.fourteen;


public class FourInArrayNotFoundException extends RuntimeException {

    private final static String DEFAULT_MSG = "Четерые не существует в массиве";

    public FourInArrayNotFoundException() {
        super(DEFAULT_MSG);
    }

    public FourInArrayNotFoundException(String message) {
        super(message);
    }

    public FourInArrayNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
