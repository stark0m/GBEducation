package Algorithms.Lesson3.Deque;

public interface Deque<E> {


    boolean insertLeft(E value);

    boolean insertRight(E value);

    E removeLeft();

    E removeRight();

    E peekLeft();

    E peekRight();

    int size();

    boolean isEmpty();

    boolean isFull();

    void display();
}
