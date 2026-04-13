package com.Sonnet.List;

/**
 * 自定义单向链表
 *  <T>泛型变量
 */
public class MyNode<T> {

    private T data; //链表中的存储数据

    private MyNode<T> next; //下一个链

    public MyNode() {
    }

    public MyNode(T data, MyNode<T> next) {
        this.data = data;
        this.next = next;
    }

    /**
     * 获取
     * @return data
     */
    public T getData() {
        return data;
    }

    /**
     * 设置
     * @param data
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * 获取
     * @return next
     */
    public MyNode<T> getNext() {
        return next;
    }

    /**
     * 设置
     * @param next
     */
    public void setNext(MyNode<T> next) {
        this.next = next;
    }

    public String toString() {
        return "MyNode{data = " + data + ", next = " + next + "}";
    }
}
