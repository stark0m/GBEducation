package Algorithms.lesson4.deque;




import Algorithms.lesson4.queue.Queue;

public interface Deque<E>  extends Queue<E> {




    boolean insertLeft(E value);
    boolean insertRight(E value);

    E removeLeft();
    E removeRight();
    class Node<E> {
        public E item;
        public Node<E> next;
        public Node<E> prev;

        public Node(E item, Node<E> next,Node<E> prev) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }

}