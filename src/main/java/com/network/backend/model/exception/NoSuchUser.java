package com.network.backend.model.exception;

public class NoSuchUser extends RuntimeException{
    public NoSuchUser(String message) {
        super(message);
    }
}
