package com.network.backend.model.exception;

public class NoSuchPost extends RuntimeException{
    public NoSuchPost(String message) {
        super(message);
    }
}
