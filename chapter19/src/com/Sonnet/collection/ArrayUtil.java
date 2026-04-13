package com.Sonnet.collection;

import java.util.Arrays;

public class ArrayUtil {
    //使用数组来存储数据，因为不知道存储什么样的数据，所以使用Object数组
    //支持存储所有类型的数据
    private Object[] elements;

    //集合中的存储个数,默认值是0
    private int size;

    public ArrayUtil() {
        this(16);
    }

    public ArrayUtil(int capacity) {
        elements = new Object[16];
    }

    public int getSize() {
        return size;
    }

    public void add(Object object) {
        //数组中存储满了，数组需要扩容，才可以存储新的元素
        if (this.size >= elements.length) {
            //4 >> 1 = 2     4 << 1 = 8
            //扩容1.5
            int length = elements.length + elements.length >> 1;
            elements = Arrays.copyOf(elements, length);
        }

        elements[this.size++] = object;
    }

    public void delete(Object object) {
        if (object == null) return;
        int index = -1;
        for (int i = 0; i < this.size; i++) {
            if (object.equals(elements[i])) {
                index = i;
                break;
            }
        }
        //System.arraycopy(Object src, int srcPos, Object dest, int destPos, int length);
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        this.size--;
    }

    public void update(int index, Object object) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("下标越界");
        }

        elements[index] = object;
    }

    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("下标越界");
        }
        return elements[index];
    }
}
