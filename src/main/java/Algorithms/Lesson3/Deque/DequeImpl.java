package Algorithms.Lesson3.Deque;

public class DequeImpl<E> implements Deque<E> {
    protected final int DEFAULT_TAIL = -1;
    protected final int DEFAULT_HEAD = 0;

    protected final E[] data;
    protected int size;
    protected int tail;
    protected int head;



    public DequeImpl(int maxSize) {
        this.data = (E[]) new Object[maxSize];
        tail = DEFAULT_TAIL;
        head = DEFAULT_HEAD;

    }

    @Override
    public E removeRight() {
        if (isEmpty()) {
              return null;
        }
        E value = peekRight();
        data[tail--] = null;
        if (tail==DEFAULT_TAIL && size>1){
            tail = data.length-1;
        }
        size--;

        return value;
    }

    @Override
    public boolean insertLeft(E value) {
        if (isFull()) {
            return false;
        }

        if (head == 0) {
            head = data.length;
        }
        data[--head] = value;
        size++;
        return true;
    }

    @Override
    public boolean insertRight(E value) {
        if (isFull()) {
            return false;
        }

        if (tail == data.length - 1) {
            tail = DEFAULT_TAIL;
        }


        data[++tail] = value;
        size++;
        return true;
    }


    @Override
    public E removeLeft() {
        if (isEmpty()) {

            return null;
        }

        E value = data[head++];
        data[head - 1] = null;
        if (head == data.length) {
            head = 0;
        }


        size--;

        return value;

    }

    @Override
    public E peekLeft() {
        return (E) data[head];
    }

    @Override
    public E peekRight() {
        return (E) data[tail];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == data.length;
    }

    @Override
    public void display() {
        System.out.println(this);

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < data.length; i++) {
            if (data[i] != null) {
                if (i == head) {
                    sb.append("L: ");
                }
                if (i == tail) {
                    sb.append("R: ");
                }
                sb.append(data[i]);
                if (i != data.length - 1) {
                    sb.append(", ");
                }
            } else {
                sb.append("NULL, ");
            }

        }
        return sb.append("]").append(size+" head:"+head+" tail:"+tail).toString();
    }
}
