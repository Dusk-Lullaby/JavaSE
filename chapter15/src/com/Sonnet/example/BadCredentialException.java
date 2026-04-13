package com.Sonnet.example;

public class BadCredentialException extends Exception{

    public BadCredentialException() {
    }

    public BadCredentialException(String msg) {
        super(msg);
    }
}
