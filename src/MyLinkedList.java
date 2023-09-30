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
        Node<E> lastNode = Node.create(value);
        if(first == null) {
            first = last = lastNode;
        } else{
            last.next = lastNode;
            last = lastNode;
        }
        size++;
    }

    public void remove(int index) {
        Objects.checkIndex(index, size);
        if(index == 0) {
            first = first.next;
            if(first == null)
                last = null;
        } else {
            getNodeByIndex(index - 1).next = getNodeByIndex(index + 1);
            if(index == size - 1) {
                last = getNodeByIndex(index - 1);
            }
        }
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
        return getNodeByIndex(index).element;
    }
    public void print() {
        System.out.println("Елементи MyLinkedList: ");
        Node<E> current = first;
        for (int i = 0; i < size; i++) {
            System.out.print(current.element + " ");
            current = current.next;
        }
        System.out.print("\n");
    }
    public Node<E> getNodeByIndex(int index) {
        Node<E> current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }
}
