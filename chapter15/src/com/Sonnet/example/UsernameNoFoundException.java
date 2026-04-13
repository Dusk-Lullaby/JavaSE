package com.Sonnet.example;

/**
 * 用户名不存在异常
 *
 * 异常命名规范：场景描述 + Exception
 */
public class UsernameNoFoundException extends Exception{

    public UsernameNoFoundException() {
    }

    public UsernameNoFoundException (String msg) {
        super(msg);
    }
}
