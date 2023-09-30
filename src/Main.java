
public class Main {
    public static void main(String[] args) {
        //MyArrayList
        System.out.println("\nMyArrayList test:\n");
        MyArrayList<Integer> arrayList = new MyArrayList<>();
        System.out.println("Розмір масиву: " + arrayList.size());
        arrayList.add(100);
        arrayList.add(50);
        arrayList.add(25);
        arrayList.print();
        System.out.println("Розмір масиву: " + arrayList.size());
        System.out.println("Елемент за індексом 1: " + arrayList.get(1));
        arrayList.remove(1);
        System.out.println("Елемент з індексом 1 вилучено з масиву");
        System.out.println("Розмір масиву: " + arrayList.size());
        arrayList.print();
        arrayList.clear();
        System.out.println("Масив очищено");
        System.out.println("Розмір масиву: " + arrayList.size());
        arrayList.print();

        //MyLinkedList
        System.out.println("\nMyLinkedList test:\n");
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.add(100);
        linkedList.add(50);
        linkedList.add(25);
        linkedList.print();
        System.out.println("Довжина списку: " + linkedList.size());
        System.out.println("Елемент за індексом 1: " + linkedList.get(1));
        linkedList.remove(1);
        System.out.println("Елемент з індексом 1 вилучено зі списку");
        System.out.println("Довжина списку: " + linkedList.size());
        linkedList.print();
        linkedList.clear();
        System.out.println("Список очищено");
        System.out.println("Довжина списку: " + linkedList.size());
        linkedList.print();

        //MyQueue
        System.out.println("MyQueue test:\n");
        MyQueue<Integer> myQueue = new MyQueue<>();
        myQueue.add(100);
        myQueue.add(50);
        myQueue.add(25);
        myQueue.print();
        System.out.println("Довжина черги: " + myQueue.size());
        System.out.println("Виклик методу peek: " + myQueue.peek());
        System.out.println("Виклик методу poll: " + myQueue.poll());
        myQueue.print();
        System.out.println("Довжина черги: " + myQueue.size());
        myQueue.clear();
        System.out.println("Чергу очищено");
        System.out.println("Довжина черги: " + myQueue.size());
        myQueue.print();


        //MyStack
        System.out.println("MyStack test:\n");
        MyStack<String> myStack = new MyStack<>();
        myStack.push("Dmytro");
        myStack.push("Ruslana");
        myStack.push("Nikola");
        myStack.push("Khrystyna");
        myStack.push("Andrii");
        myStack.push("Oleksandr");
        myStack.print();
        System.out.println("Довжина стеку: " + myStack.size());
        System.out.println("Виклик методу peek: " + myStack.peek());
        System.out.println("Виклик методу pop: " + myStack.pop());
        myStack.print();
        System.out.println("Довжина стеку: " + myStack.size());
        myStack.clear();
        System.out.println("Стек очищено");
        System.out.println("Довжина стеку: " + myStack.size());
        myStack.print();

        //MyHashMap
        System.out.println("MyHashMap test:\n");
        MyHashMap<Integer, String> hashMap= new MyHashMap<>();
        hashMap.put(1, "Computer");
        System.out.println("Hashmap.get(1): " + hashMap.get(1));
        hashMap.put(2, "Laptop");
        System.out.println("Hashmap.get(2): " + hashMap.get(2));
        hashMap.put(3, "Phone");
        System.out.println("Hashmap.get(3): " + hashMap.get(3));
        hashMap.put(4, "Microphone");
        System.out.println("Hashmap.get(4): " + hashMap.get(4));
        System.out.println("Hashmap.get(2): " + hashMap.get(2));
        hashMap.put(5, "Smartphone");
        System.out.println("Hashmap.get(5): " + hashMap.get(5));
        hashMap.put(6, "PC");
        hashMap.put(5, "Smartphone");
        hashMap.put(5, "Phone");
        hashMap.remove(5);
        hashMap.remove(6);
        hashMap.remove(1);
        hashMap.remove(3);
        System.out.println("Розмір HashMap: " + hashMap.size());
        hashMap.print();
        hashMap.clear();
        System.out.println("Розмір HashMap: " + hashMap.size());
        hashMap.print();
    }
}