package com.Sonnet.Map;

public class MyEntry<K, V> {

    private K key;

    private V value;

    private MyEntry<K, V> next;

    public MyEntry() {
    }

    public MyEntry(K key, V value, MyEntry<K, V> next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public MyEntry<K, V> getNext() {
        return next;
    }

    public void setNext(MyEntry<K, V> next) {
        this.next = next;
    }

    /**
     * 获取
     * @return key
     */
    public K getKey() {
        return key;
    }

    /**
     * 设置
     * @param key
     */
    public void setKey(K key) {
        this.key = key;
    }

    /**
     * 获取
     * @return value
     */
    public V getValue() {
        return value;
    }

    /**
     * 设置
     * @param value
     */
    public void setValue(V value) {
        this.value = value;
    }

    public String toString() {
        return "MyEntry{key = " + key + ", value = " + value + "}";
    }
}
