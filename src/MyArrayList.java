//Напишіть свій клас MyArrayList як аналог класу ArrayList.
//
//        Можна використовувати 1 масив для зберігання даних.
//
//        Методи
//
//        add(Object value) додає елемент в кінець +
//        remove(int index) видаляє елемент із вказаним індексом +
//        clear() очищає колекцію +
//        size() повертає розмір колекції +
//        get(int index) повертає елемент за індексом +

import java.util.Objects;

public class MyArrayList<E> {
    private static final int DEFAULT_CAPACITY = 5;
    private Object[] myList;
    private int size;
    public MyArrayList() {
        this(DEFAULT_CAPACITY);
    }
    public MyArrayList(int size) {
        if(size <= 0)
            throw new IllegalArgumentException();
        myList = new Object[size];
    }

    public void add(E value) {
        this.resizeArray();
        myList[size] = value;
        size++;
    }
    private void resizeArray() {
        if(myList.length == size) {
            Object[] copy = new Object[myList.length * 2];
            System.arraycopy(myList, 0, copy, 0, size);
            myList = copy;
        }
    }
    public void remove(int index) {
        Objects.checkIndex(index, size);
        System.arraycopy(myList, index + 1, myList, index, size - index - 1);
        size--;
    }
    public void clear() {
        size = 0;
        myList = new Object[DEFAULT_CAPACITY];
    }
    public int size() {
        return size;
    }
    @SuppressWarnings("unchecked")
    public E get(int index) {
        Objects.checkIndex(index, size);
        return (E) myList[index];
    }
    public void print() {
        System.out.print("Елементи MyArrayList: ");
        for(int i = 0; i < size; i++)
            System.out.print(myList[i] + " ");
        System.out.print("\n");
    }
}
