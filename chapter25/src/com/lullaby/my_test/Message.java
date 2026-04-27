package com.lullaby.my_test;

import java.io.Serializable;

public class Message<T> implements Serializable {

    private T data;

    private String action;

    public Message(T data, String action) {
        this.data = data;
        this.action = action;
    }

    public T getData() {
        return data;
    }

    public String getAction() {
        return action;
    }
}
