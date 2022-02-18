package Algorithms.Lesson2.Sorting;

public class SelectionSort {
    public static void sort(Integer[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;

//            System.out.println("i: " + i + Arrays.toString(arr));
        }
    }
}
