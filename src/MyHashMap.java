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


import java.util.Arrays;
import java.util.Objects;

public class MyHashMap<E, T> {
    private static final int CAPACITY = 16;
    private int size;
    private NodeMap<E, T>[] table;

    @SuppressWarnings("unchecked")
    public MyHashMap() {
        size = 0;
        table = (NodeMap<E, T>[]) new NodeMap[CAPACITY];
    }
    public void put(E key, T value) {
        NodeMap<E, T> node = new NodeMap<>(key, value);
        int index = getBucketIndex(key); //Обчислити індекс бакета в який записувати
        Objects.checkIndex(index, table.length); //Перевірка індексу ноду
        NodeMap<E, T> currentNode = table[index];

        while (currentNode != null) {
            if (currentNode.key.equals(key)) {
                currentNode.value = value; // Оновлення значення
                return;
            }
            currentNode = currentNode.next;
        }

        node.next = table[index];
        table[index] = node;

        size++;
        if(size >= table.length) {
            refactorMap();
        }
    }
    public void remove(E key) {
        int index = getBucketIndex(key);
        NodeMap<E, T> prev = null;
        NodeMap<E, T> current = table[index];

        while (current != null) {
            if (current.key.equals(key)) {
                if (prev != null) {
                    prev.next = current.next;
                } else {
                    table[index] = current.next; //Якщо це єдиний елемент в бакеті
                }
                size--;
                return;
            }
            prev = current;
            current = current.next;
        }
    }
    public void clear() {
         Arrays.fill(table, null);
         size = 0;
    }
    public int size() {
        return size;
    }
    public T get(E key) {
        int index = getBucketIndex(key);
        NodeMap<E, T> current = table[index];
        while (current != null) {
            if (current.key.equals(key)) { //Шукаємо ключ в бакеті
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    public int getBucketIndex(E key) {
        return key.hashCode() % table.length;
    }

    @SuppressWarnings("unchecked")
    private void refactorMap() {
        NodeMap<E, T>[] refactoredMap = (NodeMap<E, T>[]) new NodeMap[table.length * 2];

        for (NodeMap<E, T> node : table) {
            while (node != null) { //Перебираємо по зв'язаному списку
                NodeMap<E, T> next = node.next;
                int index = getBucketIndex(node.key);
                node.next = refactoredMap[index];
                refactoredMap[index] = node;
                node = next;
            }
        }

        table = refactoredMap;
    }

    @Override
    public String toString() {
        return "MyHashMap{" +
                "size=" + size +
                ", table=" + Arrays.toString(table) +
                '}';
    }

    private static class NodeMap<E, T> {
        private final E key;
        private T value;
        private NodeMap<E, T> next;

        public NodeMap(E key, T value) {
            this.key = key;
            this.value = value;
        }
    }
}
