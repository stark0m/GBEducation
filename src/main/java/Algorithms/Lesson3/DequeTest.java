package Algorithms.Lesson3;

import Algorithms.Lesson3.Deque.DequeImpl;
import Algorithms.Lesson3.Deque.Deque;


public class DequeTest {
    public static void main(String[] args) {
        testDeue();
    }

    private static void testDeue() {

        Deque<Integer> deque = new DequeImpl<>(6);
        System.out.println("add Left: " + deque.insertLeft(1));
        deque.display();
        System.out.println("add Right: " + deque.insertRight(2));
        deque.display();
        System.out.println("add Right: " + deque.insertRight(3));
        deque.display();
        System.out.println("add Left: " + deque.insertLeft(4));
        deque.display();
        System.out.println("add Left: " + deque.insertLeft(5));
        deque.display();
        System.out.println("add Left: " + deque.insertLeft(6));
        deque.display();

        System.out.println("remove left: " + deque.removeLeft());
        deque.display();
        System.out.println("remove left: " + deque.removeLeft());
        deque.display();
        System.out.println("remove left: " + deque.removeLeft());
        deque.display();
        System.out.println("remove left: " + deque.removeLeft());
        deque.display();
        System.out.println("remove left: " + deque.removeLeft());
        deque.display();
        System.out.println("remove left: " + deque.removeLeft());
        deque.display();
        System.out.println("remove left: " + deque.removeLeft());
        deque.display();

        System.out.println("-----------------");
        System.out.println("add Right: " + deque.insertRight(7));
        deque.display();
        System.out.println("add Right: " + deque.insertRight(8));
        deque.display();
        System.out.println("add Right: " + deque.insertRight(9));
        deque.display();
        System.out.println("add Left: " + deque.insertLeft(10));
        deque.display();
        System.out.println("add Left: " + deque.insertLeft(11));
        deque.display();
        System.out.println("add Left: " + deque.insertLeft(12));
        deque.display();

        System.out.println("-----------------");
        System.out.println("remove right: " + deque.removeRight());
        deque.display();
        System.out.println("remove right: " + deque.removeRight());
        deque.display();
        System.out.println("remove right: " + deque.removeRight());
        deque.display();
        System.out.println("remove right: " + deque.removeRight());
        deque.display();
        System.out.println("remove right: " + deque.removeRight());
        deque.display();
        System.out.println("remove right: " + deque.removeRight());
        deque.display();
        System.out.println("remove right: " + deque.removeRight());
        deque.display();
    }
}
