package com.network.backend.exception;

public class NoSuchComment extends RuntimeException{
    public NoSuchComment(String message) {
        super(message);
    }
}
