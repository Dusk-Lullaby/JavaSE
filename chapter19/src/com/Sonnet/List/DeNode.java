package com.Sonnet.List;

/**
 * 双向链表
 * @param <T>
 */
public class DeNode<T> {

    private T data; //链中存储的数据

    private DeNode<T> prev; //前一个链

    private DeNode<T> next; //后一个链


    public DeNode() {
    }

    public DeNode(T data, DeNode<T> prev, DeNode<T> next) {
        this.data = data;
        this.prev = prev;
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
     * @return prev
     */
    public DeNode<T> getPrev() {
        return prev;
    }

    /**
     * 设置
     * @param prev
     */
    public void setPrev(DeNode<T> prev) {
        this.prev = prev;
    }

    /**
     * 获取
     * @return next
     */
    public DeNode<T> getNext() {
        return next;
    }

    /**
     * 设置
     * @param next
     */
    public void setNext(DeNode<T> next) {
        this.next = next;
    }

    public String toString() {
        return "DeNode{data = " + data + ", prev = " + prev + ", next = " + next + "}";
    }
}
