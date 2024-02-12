package com.alinem.howtodo.exception;

public class UserNotFound extends RuntimeException{



    public UserNotFound(String message) {
        super(message);
    }
}
