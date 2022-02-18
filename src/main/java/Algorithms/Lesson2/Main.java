package Algorithms.Lesson2;

import Algorithms.Lesson2.Laptop.Laptop;
import Algorithms.Lesson2.Sorting.LaptopSorting;
import Algorithms.Lesson2.Sorting.MyArray;
import Algorithms.Lesson2.Sorting.SelectionSort;
import Algorithms.Lesson2.Sorting.SpeedTest;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
/*        MyArray.isRepeat = false;
        MyArray.isShuffle = true;
        final int SIZE = 10;
        Integer[] arr = MyArray.getArray(SIZE, 3);

        SelectionSort.sort(arr); // реализована сортировка выбором с подстановкой максимального и минимального значений за один проход
        */

        final int LAPTOP_COUNT = 100;
        Laptop[] laptops;
        laptops = Laptop.genLaptop(LAPTOP_COUNT);


        System.out.println("сгенерирован массив ноутбуков в количестве "+ LAPTOP_COUNT+" штук");
        LaptopSorting.showArray (laptops);

        SpeedTest.startTime();
        LaptopSorting.sort(laptops);
        System.out.printf("%nВремя затраченное на сортировку ");
        SpeedTest.endTime();

        System.out.println("Произведена сортировка голобиным алгоритмом по Цене>Количеству оперативной памяти>Имени бренда производителя ");
        System.out.println("Результат сортировки: ");
        LaptopSorting.showArray (laptops);




    }
}
