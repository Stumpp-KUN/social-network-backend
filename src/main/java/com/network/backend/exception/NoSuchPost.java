package com.network.backend.exception;

public class NoSuchPost extends RuntimeException{
    public NoSuchPost(String message) {
        super(message);
    }
}
