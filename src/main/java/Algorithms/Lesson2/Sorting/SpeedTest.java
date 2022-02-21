package Algorithms.Lesson2.Sorting;



import java.util.Arrays;

public class SpeedTest {

    private static Long time;





    public static void startTime() {
        time = System.currentTimeMillis();
    }

    public static void endTime() {
        time = System.currentTimeMillis() - time;
        System.out.println(time+" мс");

    }

    public static void printSortName(String sortName) {
        System.out.printf("%s: ", sortName);
    }

    public static void printArray(Integer[] arr) {
        System.out.println(Arrays.toString(arr));
    }



}
