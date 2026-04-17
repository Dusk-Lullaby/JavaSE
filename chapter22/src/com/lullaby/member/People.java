package com.lullaby.member;

public class People {

    public void takePhoto(String name) {
        System.out.println("给" + name + "拍照");
    }

//    public void travel(String name) {
//        Camera c = new Camera() {
//            @Override
//            public void takePhoto(String name) {
//                People.this.takePhoto(name);
//            }
//        };
//    }

//    public void travel(String name) {
//        Camera c = str -> this.takePhoto(str);
//    }

    public void travel(String name) {
        Camera c = this::takePhoto;
        c.takePhoto(name);
    }
}
