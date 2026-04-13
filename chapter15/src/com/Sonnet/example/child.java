package com.Sonnet.example;

public class child extends father{

    String username;
    String password;

    public child(String username, String password) {
        this.username = username;
        this.password = password;
    }

    //必须要重写方法，并且同的异常或者是该类的子集
    //可以抛出Exception或者RuntimeException等
    //但不能抛出父类Throwable
    @Override
    public void eat() throws Exception {
        super.eat();
    }

    //父类没有声明抛出异常
    //此时子类只能声明抛出运行时异常
    //不能抛出检查异常
    @Override
    public void sleep() throws RuntimeException{

    }

    //父类中的方法没有声明抛出异常，子类中方法不能声明抛出检查异常
    //只能捕获处理
    @Override
    public void login() {
        try {
            Example6.login(username, password);
        } catch (UsernameNoFoundException e) {
            throw new RuntimeException(e);
        } catch (BadCredentialException e) {
            throw new RuntimeException(e);
        }
    }
}
