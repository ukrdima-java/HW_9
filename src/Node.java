public class Node<E> {
    E element;
    Node<E> next;

    public Node(E element) {
        this.element = element;
    }
    @SuppressWarnings("unchecked")
    public static <E> Node<E> create(E element) {
        return new Node(element);
    }
}
