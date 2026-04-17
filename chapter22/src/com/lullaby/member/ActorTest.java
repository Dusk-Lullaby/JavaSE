package com.lullaby.member;

public class ActorTest {
    public static void main(String[] args) {
//        Actor actor = new Actor() {
//            @Override
//            public void perform(Person p) {
//                p.sing();
//                p.dance();
//            }
//        };

//        Actor actor = p -> {
//            p.sing();
//            p.dance();
//        };

        Actor actor = Person::dance;
        Actor actor1 = Person::sing;
        actor.perform(new Person());
        actor1.perform(new Person());
    }
}
