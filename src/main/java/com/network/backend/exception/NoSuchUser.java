package com.network.backend.exception;

public class NoSuchUser extends RuntimeException{
    public NoSuchUser(String message) {
        super(message);
    }
}
