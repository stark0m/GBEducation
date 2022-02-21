package Algorithms.Lesson2.Sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void sort(Integer[] arr) {
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length / 2 +1; i++) {
            int min = i;
            int max = arr.length-i -1;

            for (int j = i + 1; j < arr.length-i; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
                if (arr[j-1] > arr[max]) {
                    max = j-1;
                }
            }

            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;

            if (max==i) {
                max=min;
            }
            temp=arr[arr.length-1-i];
            arr[arr.length-1-i]=arr[max];
            arr[max]=temp;
           System.out.println("i: " + i + Arrays.toString(arr));
        }
    }
}
