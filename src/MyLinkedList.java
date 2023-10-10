//Напишіть свій клас MyLinkedList як аналог класу LinkedList.
//
//        Не можна використовувати масив. Кожний елемент повинен бути окремим об'єктом-посередником (Node - нода), що зберігає посилання на попередній та наступний елемент колекції (двозв'язний список).
//
//        Методи
//
//        add(Object value) додає елемент в кінець +
//        remove(int index) видаляє елемент із вказаним індексом +
//        clear() очищає колекцію +
//        size() повертає розмір колекції +
//        get(int index) повертає елемент за індексом +

import java.util.Objects;

public class MyLinkedList<E> {
    private int size;
    private Node<E> first;
    private Node<E> last;

    public void add(E value) {
        Node<E> newNode = Node.create(value);
        if(first == null) {
            first = last = newNode;
        }
        else {
            last.next = newNode;
            newNode.prev = last;
            last = newNode;
        }
        size++;
    }

    public void remove(int index) {
        Objects.checkIndex(index, size);
        Node<E> currentNode = first;
        for(int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        Node<E> previousNode = currentNode.prev;
        previousNode.next = currentNode.next;
        currentNode.next.prev = previousNode;
        size--;
    }
    public void clear() {
        first = last = null;
        size = 0;
    }
    public int size() {
        return size;
    }
    public E get(int index) {
        Objects.checkIndex(index, size);
        Node<E> currentNode = first;
        for(int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode.element;
    }
    public void print() {
        Node<E> currentNode = first;
        System.out.println("Елементи MyLinkedList: ");
        for(int i = 0; i < size; i++) {
            System.out.print(currentNode.element + " ");
            currentNode = currentNode.next;
        }
    }
}
