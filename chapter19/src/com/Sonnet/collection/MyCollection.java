package com.Sonnet.collection;

import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Iterator;

//定义了泛型变量T， 在使用MyCollection创建对象的时候，就需要使用具体的数据类型来替换泛型变量
public class MyCollection<T> extends AbstractCollection<T> {
    private Object[] elements;

    private int size;

    public MyCollection() {
        this(16);
    }

    public MyCollection(int capacity) {
        elements = new Object[16];
    }

    @Override
    public boolean add(T object) {
        if (size == elements.length) {
            int length = elements.length + elements.length >> 1;
            elements = Arrays.copyOf(elements, length);
        }
        elements[size++] = object;
        return true;
    }

    @Override
    public Iterator<T> iterator() {
        return new CollectionIterator();
    }

    @Override
    public int size() {
        return size;
    }

    class CollectionIterator implements Iterator<T> {

        private int cursor; //光标，实际上就是下标

        @Override
        public boolean hasNext() {
            return cursor < size;
        }

        @Override
        public T next() {
            if (cursor < 0 || cursor >= size) {
                throw new ArrayIndexOutOfBoundsException("下标越界");
            }
            return (T) elements[cursor++];
        }

        @Override
        public void remove() {
            if (cursor > size || cursor < 0) {
                throw new ArrayIndexOutOfBoundsException("下标越界");
            }
            System.arraycopy(elements, cursor , elements, cursor - 1, size - cursor);
            cursor--;
            size--;
        }
    }
}
