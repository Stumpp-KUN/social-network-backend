package com.network.backend.model.exception;

public class NoSuchComment extends RuntimeException{
    public NoSuchComment(String message) {
        super(message);
    }
}
