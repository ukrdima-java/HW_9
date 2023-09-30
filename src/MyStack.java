//Написати свій клас MyStack як аналог класу Stack, який працює за принципом LIFO (last-in-first-out).
//
//        Можна робити за допомогою Node або використати масив.
//
//        Методи
//
//        push(Object value) додає елемент в кінець +
//        remove(int index) видаляє елемент за індексом +
//        clear() очищає колекцію +
//        size() повертає розмір колекції +
//        peek() повертає перший елемент стеку +
//        pop() повертає перший елемент стеку та видаляє його з колекції +

import java.util.Arrays;
import java.util.Objects;

public class MyStack<E> {
    private Object[] array;
    private int size;
    private static final int DEFAULT_CAPACITY = 5;

    public MyStack() {
        array = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public void push(E value) {
        resizeArray();
        array[size++] = value;
    }

    public void remove(int index) {
        Objects.checkIndex(index, size);
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        array[--size] = null;
    }

    public void clear() {
        array = null;
        size = 0;
    }

    public int size() {
        return size;
    }
    @SuppressWarnings("unchecked")
    public E peek() {
        if (size == 0) {
            throw new IllegalStateException();
        }
        return (E) array[size - 1];
    }
    @SuppressWarnings("unchecked")
    public E pop() {
        if (size == 0) {
            throw new IllegalStateException();
        }
        E value = (E) array[--size];
        array[size] = null;
        return value;
    }

    private void resizeArray() {
        if (size == array.length) {
            int newCapacity = size * 2;
            array = Arrays.copyOf(array, newCapacity);
        }
    }

    public void print() {
        System.out.println("Елементи MyStack: ");
        for (int i = size - 1; i >= 0; i--) {
            System.out.print(array[i] + " ");
        }
        System.out.print("\n");
    }
}
