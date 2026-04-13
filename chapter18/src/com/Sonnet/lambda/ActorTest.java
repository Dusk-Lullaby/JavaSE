package com.Sonnet.lambda;

public class ActorTest {

    public static void main(String[] args) {

        // 匿名内部类
        Actor actor = new Actor() {
            @Override
            public void performance() {
                System.out.println("蔡徐坤");
            }
        };
        actor.performance();

        Actor a = () -> System.out.println("波罗蜜");
        a.performance();

        // Lambda表达式
        Actor actor1 = () -> System.out.println("蔡徐坤");
        actor1.performance();
    }
}
