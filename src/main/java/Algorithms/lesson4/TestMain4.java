package Algorithms.lesson4;

import java.util.*;

public class TestMain4 {

    public static void main(String[] args) {
//        testLinkedList();

 //       testIterator();
        testDequeLinkedList();
        testHomeWork();
    }

    private static void testDequeLinkedList() {
        DequeLinkedList<Integer> dequeLinkedList = new DequeLinkedList<>();
        dequeLinkedList.insertRight(1);
        dequeLinkedList.insertRight(2);
        dequeLinkedList.insertRight(3);
        dequeLinkedList.insertRight(4);
        dequeLinkedList.insertRight(5);
        dequeLinkedList.insertRight(6);
        dequeLinkedList.insertRight(7);
        dequeLinkedList.insertRight(8);
        dequeLinkedList.insertLeft(9);
        dequeLinkedList.insertLeft(10);

        dequeLinkedList.display();
        System.out.println(dequeLinkedList.removeLeft());
        System.out.println(dequeLinkedList.removeRight());
        dequeLinkedList.display();
        int tmp = dequeLinkedList.remove(3);
        System.out.println(tmp);
        dequeLinkedList.display();
        dequeLinkedList.insert(1,15);

        dequeLinkedList.display();
        System.out.println(dequeLinkedList.removeLeft());
        System.out.println(dequeLinkedList.removeLeft());
        System.out.println(dequeLinkedList.removeLeft());
        System.out.println(dequeLinkedList.removeLeft());
        System.out.println(dequeLinkedList.removeLeft());
        System.out.println(dequeLinkedList.removeLeft());
        System.out.println(dequeLinkedList.removeLeft());
        System.out.println(dequeLinkedList.removeLeft());
        System.out.println(dequeLinkedList.removeLeft());

        dequeLinkedList.display();

        dequeLinkedList.insertLeft(4);
        dequeLinkedList.insertRight(5);
        dequeLinkedList.insertRight(6);
        dequeLinkedList.insertRight(7);
        dequeLinkedList.insertRight(8);
        dequeLinkedList.insertLeft(9);
        dequeLinkedList.insertLeft(10);

        dequeLinkedList.display();
        System.out.println("реализация вывода коллекции через цыкл for");
        System.out.print("(");
        for (Integer integer : dequeLinkedList) {
            System.out.print(integer +" ");
        }
        System.out.println(")");
        System.out.println("реализация вывода коллекции через класс итератор методом while");
        Iterator<Integer> iterator = dequeLinkedList.iterator();

        while (iterator.hasNext()){

            System.out.print(iterator.next()+"->");
        }
        System.out.println("null");
        System.out.println("количество элементов в коллекции: "+dequeLinkedList.size);
        iterator = dequeLinkedList.iterator();
        System.out.println("Повторно проходим по элементам колекции через цыкл while");
        while (iterator.hasNext()){

            System.out.print(iterator.next()+"->");
        }
        System.out.println("null");

    }

    private static void testLinkedList() {

        TwoSideLinkedList<Integer> linkedList = new TwoSideLinkedListImpl<>();

        linkedList.insertFirst(1);
        linkedList.insertFirst(2);
        linkedList.insertFirst(3);
        linkedList.insertFirst(4);
        linkedList.insertFirst(5);
        linkedList.insertFirst(6);
        linkedList.insertFirst(7);
        linkedList.insertFirst(8);
        linkedList.insertLast(9);
        linkedList.insertLast(10);
        linkedList.insertLast(11);

        linkedList.display();

        System.out.println("Find 2: " + linkedList.contains(2));
        System.out.println("Find 1: " + linkedList.contains(1));
        System.out.println("Find 4: " + linkedList.contains(4));
        System.out.println("Find 4444: " + linkedList.contains(4444));

        System.out.println("remove first: " + linkedList.removeFirst());
        linkedList.remove(4);
        linkedList.remove(11);
//
        linkedList.display();

    }

    private static void testHomeWork() {
        //ДОЛЖНО РАБОТАТЬ!
        final int COLLECTION_SIZE = 10;

        SimpleLinkedListImpl<Integer> linkedList = new SimpleLinkedListImpl<>();

        System.out.println("Генерируем массив linkedList, количество элементов:" + COLLECTION_SIZE);
        System.out.print("[");
        for (int i = 0; i < COLLECTION_SIZE; i++) {
            int rand = new Random().nextInt(50);
            linkedList.insertFirst(rand);
            System.out.print(rand + " ");

        }
        System.out.println(") сгенерированная коллекция");
        System.out.println("Выводим содержимое коллекции методом for");


        for (Integer value : linkedList) {
            System.out.println("value: " + value);
        }
    }


    private static void testIterator() {
        List<Integer> linkedList = new java.util.LinkedList<>();
        Collections.addAll(linkedList, 1, 2, 3, 4, 5, 6, 7, 8, 9);

/*        for (Integer integer : linkedList) {
            System.out.println(integer);
        }*/
        ListIterator<Integer> iterator = linkedList.listIterator();
        //first:reset
        while (iterator.hasNext()) {
            Integer integer = iterator.next();
            System.out.println(integer + " до него: " + iterator.previousIndex());
        }

    }
}
