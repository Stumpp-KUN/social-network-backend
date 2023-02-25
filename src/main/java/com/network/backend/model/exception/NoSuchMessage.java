package com.network.backend.model.exception;

public class NoSuchMessage extends RuntimeException{
    public NoSuchMessage(String message) {
        super(message);
    }
}
