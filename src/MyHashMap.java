//Написати свій клас MyHashMap як аналог класу HashMap.
//
//        Потрібно робити за допомогою однозв'язної Node.
//
//        Не може зберігати дві ноди з однаковими ключами.
//
//        Методи
//
//        put(Object key, Object value) додає пару ключ + значення +
//        remove(Object key) видаляє пару за ключем +
//        clear() очищає колекцію +
//        size() повертає розмір колекції +
//        get(Object key) повертає значення (Object value) за ключем +


public class MyHashMap<E, T> {
    private int size;
    private NodeMap<E, T> start;
    public MyHashMap() {
        size = 0;
        start = null;
    }
    public void put(E key, T value) {
        NodeMap<E, T> nodeMap = new NodeMap<>(key, value);
        if(size == 0) {
            start = nodeMap;
            start.next = nodeMap;
            size++;
        }
        else {
            NodeMap<E, T> current = start;
            if(contains(key)) {
                for (int i = 0; i < size; i++) {
                    if(current.key.equals(key))
                        current.value = value;
                    current = current.next;
                }
            }
            else {
                for (int i = 0; i < size; i++) {
                    current = current.next;
                }
                current.next = nodeMap;
                current.next.next = nodeMap;
                size++;
            }
        }
    }
    public void remove(E key) {
        if(!contains(key))
            return;
        int index = getKeyIndex(key);
        if(index == 0) {
            start = start.next;
            size--;
        }
        else {
            getNodeByIndex(index - 1).next = getNodeByIndex(index + 1);
            size--;
        }
    }
    public void clear() {
        start = null;
        size = 0;
    }
    public int size() {
        return size;
    }
    public T get(E key) {
        if(size == 0)
            return null;
        NodeMap<E, T> current = start;
        for (int i = 0; i < size; i++) {
            if(current.key.equals(key))
                return current.value;
            current = current.next;
        }
        return null;
    }
    public boolean contains(E key) {
        if(size == 0)
            return false;
        NodeMap<E, T> current = start;
        for(int i = 0; i < size; i ++) {
            if(current.key.equals(key))
                return true;
            current = current.next;
        }
        return false;
    }
    public int getKeyIndex(E key) {
        NodeMap<E, T> current = start;
        for (int i = 0; i < size; i++) {
            if(current.key.equals(key))
                return i;
            current = current.next;
        }
        return -1;
    }
    public void print() {
        System.out.print("Елементи MyHashMap: \n");
        NodeMap<E, T> current = start;
        for (int i = 0; i < size; i++) {
            System.out.println("Key: " + current.key + " Value: " + current.value);
            current = current.next;
        }
        System.out.print("\n");
    }
    public NodeMap<E, T> getNodeByIndex(int index) {
        NodeMap<E, T> current = start;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }
    private static class NodeMap<E, T> {
        private final E key;
        private T value;
        private NodeMap<E, T> next;

        public NodeMap(E key, T value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
}
