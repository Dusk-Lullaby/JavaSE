package com.Sonnet.List;

public class MyNodeTest {

    public static void main(String[] args) {
        MyNode<String> first = new MyNode<>("一", null);
        MyNode<String> second = new MyNode<>("二", null);
        first.setNext(second);
        MyNode<String> third = new MyNode<>("三", null);
        second.setNext(third);
        MyNode<String> forth = new MyNode<>("四", null);
        third.setNext(forth);
        MyNode<String> nextNode = first;
        while(nextNode != null) {
            System.out.println(nextNode.getData());
            nextNode = nextNode.getNext();
        }
        System.out.println("================");
        MyNode<Integer> number4 = new MyNode<>(4, null);
        MyNode<Integer> number3 = new MyNode<>(3, number4);
        MyNode<Integer> number2 = new MyNode<>(2, number3);
        MyNode<Integer> number1 = new MyNode<>(1, number2);
        MyNode<Integer> next = number1;
        while (next != null) {
            System.out.println(next.getData());
            next = next.getNext();
        }
    }
}
