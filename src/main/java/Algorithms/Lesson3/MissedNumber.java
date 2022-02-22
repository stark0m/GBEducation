/*2. Дан массив из n элементов, начиная с 1.
Каждый следующий элемент равен (предыдущий + 1).
Но в массиве гарантированно 1 число пропущено. Необходимо вывести на экран пропущенное число.*/
package Algorithms.Lesson3;

import java.util.Arrays;

public class MissedNumber {

    public static void main(String[] args) {
        //  int [] array = {1,2,3,5,6,7,8,9,10,11};
        // int [] array = {1,2,3,4,5,6,7,9,10,11};
        int[] array = {1, 2, 3, 4, 5, 7, 8, 9, 10, 11, 12, 13};
        System.out.println("Задан массив" + Arrays.toString(array));
        System.out.println("Пропущенное число в массиве: " + getMisssedNumber(array));
    }

    private static int getMisssedNumber(int[] array) {
        int temp = 0;
        if (array.length == 0) {
            return 1;
        }
        if (array[0] != 1 || array.length == 0) {
            return 1;
        }
        if (array[array.length - 1] == array.length) {
            return array.length + 1;
        }

        int start, end;
        start = 0;
        end = array.length - 1;

        while ((end - start) > 1) {
            temp = (end + start) / 2;
            if (temp == array[temp - 1]) {
                start = array[temp - 1];
                temp = array[temp - 1] + 1;
            } else {
                end = temp;
                temp = array[temp - 1] - 1;
            }

        }

        return temp;
    }
}
