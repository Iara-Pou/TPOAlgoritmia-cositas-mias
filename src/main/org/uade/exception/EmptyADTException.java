package main.org.uade.exception;

public class EmptyADTException extends RuntimeException {
    public EmptyADTException(String message) {
        super(message);
    }
}