package Algorithms.lesson8;

import java.util.ArrayList;

public class HashTableImpl<K, V> implements HashTable<K, V> {

    private ArrayList<Item<K, V>>[] data;

    private int size;

    static class Item<K, V> implements Entry<K, V> {
        private final K key;
        private V value;

        public Item(K key, V value) {
            this.key = key;
            this.value = value;

        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }


        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Item{" + "key=" + key + ", value=");
            stringBuilder.append(value);
            stringBuilder.append('}');


            return stringBuilder.toString();
        }
    }

    public HashTableImpl(int initialCapacity) {
        this.data = new ArrayList[initialCapacity * 2];


    }

    public HashTableImpl() {
        this(16);
    }

    @Override
    public boolean put(K key, V value) {
        if (size() == data.length) {
            return false;
        }

        int index = hashFunc(key);

        if (data[index] == null) {
            data[index] = new ArrayList<>(1);
            data[index].add(new Item<>(key, value));
            size++;

        } else {
            data[index].add(new Item<>(key, value));
        }
        return true;


    }


    private int hashFunc(K key) {
        return Math.abs(key.hashCode() % data.length);
    }

    @Override
    public V get(K key) {
        int index = indexOf(key);
        ;
        if (index == -1) return null;


        for (Item<K, V> datum : data[index]) {

            if (datum.getKey().equals(key)) {
                return datum.getValue();
            }
        }
        return null;
    }

    private int indexOf(K key) {
        int index = hashFunc(key);
        if (data[index] == null) {
            return -1;
        }
        return index;



    }

    @Override
    public V remove(K key) {


        if (get(key) == null) {
            return null;
        }
        int index = indexOf(key);
        if (data[index].size() == 1) {
            Item<K, V> removed = data[index].get(0);
            data[index] = null;
            removed.getValue();
            size--;
            return removed.getValue();
        }

        for (Item<K, V> kvItem : data[index]) {
            if (kvItem.getKey().equals(key)) {
                data[index].remove(kvItem);
                return kvItem.getValue();
            }

        }

        return null;

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
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < data.length; i++) {
            sb.append(String.format("%s = [%s]%n", i, data[i]));
        }
        return sb.toString();
    }
}
