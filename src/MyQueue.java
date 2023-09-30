//Написати свій клас MyQueue як аналог класу Queue, який буде працювати за принципом FIFO (first-in-first-out).
//
//        Можна робити за допомогою Node або використати масив.
//
//        Методи
//
//        add(Object value) додає елемент в кінець +
//        clear() очищає колекцію +
//        size() повертає розмір колекції +
//        peek() повертає перший елемент з черги +
//        poll() повертає перший елемент з черги та видаляє його з колекції +

public class MyQueue<E> {
    private int size;
    private Node<E> head;
    private Node<E> tail;
    public void add(E value) {
        Node<E> lastNode = Node.create(value);
        if(head == null) {
            head = tail = lastNode;
        } else {
            tail.next = lastNode;
            tail = lastNode;
        }
        size++;
    }
    public void clear() {
        head = tail = null;
        size = 0;
    }
    public int size() {
        return size;
    }
    public E peek() {
        return head.element;
    }
    public E poll() {
        if(size <= 0)
            throw new IllegalArgumentException();
        E element = head.element;
        head = head.next;
        size--;
        if(size == 0)
            tail = null;
        return element;
    }
    public void print() {
        System.out.println("Елементи MyQueue: ");
        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            System.out.print(current.element + " ");
            current = current.next;
        }
        System.out.print("\n");
    }
}
