package Algorithms.Lesson2;

import Algorithms.Lesson2.Laptop.Laptop;
import Algorithms.Lesson2.Sorting.MyArray;
import Algorithms.Lesson2.Sorting.SelectionSort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
/*        MyArray.isRepeat = false;
        MyArray.isShuffle = true;
        final int SIZE = 10;
        Integer[] arr = MyArray.getArray(SIZE, 3);
//        arr = new Integer[]{6, 17, 4, 0, 11, 2, 9, 12, 21, 13};
        SelectionSort.sort(arr);*/

        final int LAPTOP_COUNT = 10;
        Laptop[] laptops;
        laptops = Laptop.genLaptop(LAPTOP_COUNT);
        System.out.println(laptops);


        for (Laptop laptop : laptops) {
            System.out.println(laptop);

        }
        System.out.println(Arrays.toString(laptops));

    }
}
