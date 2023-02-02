package com.network.backend.exception;

public class NoSuchMessage extends RuntimeException{
    public NoSuchMessage(String message) {
        super(message);
    }
}
