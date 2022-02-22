package Algorithms.Lesson3.Deque;

public interface Deque<E> {
    boolean insert(E value);

    E remove();

    E peekFront();

    int size();

    boolean isEmpty();

    boolean isFull();

    void display();
}
