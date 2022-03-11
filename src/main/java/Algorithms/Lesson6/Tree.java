package Algorithms.Lesson6;

public interface Tree<E extends Comparable<? super E>> {

    enum TraversMode {
        IN_ORDER, PRE_ORDER, POST_ORDER,CHECK_BALANCE
        }

    boolean contains(E value);
    boolean isBalancedInfo();

    int depth();
    boolean add(E value);

    boolean remove(E value);

    boolean isEmpty();

    int size();

    void display();

    void traverse(TraversMode mode);

}
