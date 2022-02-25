package Algorithms.lesson4;

import Algorithms.lesson4.deque.Deque;

import java.util.Iterator;

public class DequeLinkedList<E> implements Deque<E>, Iterable<E> {
    protected Node<E> first;
    protected Node<E> last;
    protected Node<E> prev;
    protected int size;


    @Override
    public boolean insert(E value) { // данная логика не реализуется в данном классе, реализуем далее перегруженный метод
        return false;
    }

    public boolean insert(int position, E value) { // реализация перегрузки метода согласно ТЗ
        if (size < position) {
            return false;
        }

        if (position == 0) {
            insertLeft(value);
        }
        if (position == size) {
            insertRight(value);
        }
        Node<E> elementToAddBefore = last;

        for (int i = 0; i < position; i++) {
            elementToAddBefore = elementToAddBefore.prev;

        }
        Node<E> newElement = new Node<>(value, null, null);
        newElement.prev = elementToAddBefore.next.prev;
        newElement.next = elementToAddBefore.next;


        elementToAddBefore.next.prev = newElement;
        elementToAddBefore.next = newElement;
        size++;

        return true;

    }

    @Override
    public E remove() {
        return null;
    }


    public E remove(E value) {
        if (!isEmpty()) {
            Node<E> toRemove = indexOf(value);
            if (toRemove == null) {
                return null;
            }
            E result = toRemove.item;
            toRemove.next.prev = toRemove.prev;
            toRemove.prev.next = toRemove.next;
            toRemove.next = toRemove.prev = null;
            size--;
            return result;
        }
        return null;
    }

    /*done*/
    public Node<E> indexOf(E value) {
        Node<E> current = first;

        while (current != null) {
            if (current.item.equals(value)) {
                return current;
            }
            current = current.next;
        }
        return null;

    }

    @Override
    public E removeLeft() {
        if (isEmpty()) {
            return null;
        }
        E result = last.item;
        last = last.prev;
        last.next.prev = null;
        last.next = null;
        size--;
        return result;
    }

    @Override
    public E removeRight() {
        if (isEmpty()) {
            return null;
        }
        E result = first.item;
        first = first.next;
        first.prev.next = null;
        first.prev = null;
        size--;
        return result;
    }

    @Override
    public E peekFront() {
        return peekRight();
    }

    public E peekBack() {
        return peekLeft();
    }

    public E peekRight() {
        return first.item;
    }

    public E peekLeft() {
        return last.item;
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
        return false;
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<E> current = last;

        while (current != null) {
            sb.append(current.item);
            if (current.prev != null) {
                sb.append(" -> ");
            }
            current = current.prev;
        }

        return sb.append("]").toString();
    }

    @Override
    public boolean insertLeft(E value) {

        if (isEmpty()) {
            first = last = new Node<>(value, first, last);
            size++;
            return true;
        }
        last.next = new Node<>(value, null, last);
        last = last.next;
        size++;
        return true;

    }

    @Override
    public boolean insertRight(E value) {
        if (isEmpty()) {
            first = last = new Node<>(value, first, last);
            size++;
            return true;
        }


        first.prev = new Node<>(value, first, null);
        first = first.prev;

        size++;
        return true;
    }


    @Override
    public Iterator<E> iterator() {
        return new DequeIterator<>();
    }



    private class DequeIterator<E> implements Iterator {
        Integer counter;
        Node<E> result;
        public DequeIterator() {
            this.counter = 0;
            result = new Node<E>((E) null, (Node<E>) null, (Node<E>) last) ;


        }


        @Override
        public boolean hasNext() {
            return size > counter;
        }

        @Override
        public E next() {
            this.counter++;
            result = result.prev;
            return result.item;

        }



        public void clearIterator(){
            counter = 0;
            result = new Node<E>((E) null, (Node<E>) null, (Node<E>) last) ;
        }
    }
}
