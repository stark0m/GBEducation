package Lesson12;

import java.util.Arrays;

public class Main {
    static final int SIZE = 1000000;
    static final int HALF = SIZE / 2;
    static float[] array = new float[SIZE];
    private static Long time;

    public static void startTime() {
        time = System.currentTimeMillis();
    }
    public static void endTime() {
        time = System.currentTimeMillis() - time;
        System.out.println(time + " мс");
    }

    public static void main(String[] args) {
        Arrays.fill(array, 1);

        startTime();
        methodA(array);
        endTime();
//        System.out.println(Arrays.toString(array)       );
//
        Arrays.fill(array, 1);
        startTime();
        try {
            methodB(array);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        endTime();
    }

    private static void methodB(float[] array) throws InterruptedException {

        float[] temArray1 = new float[HALF];
        float[] temArray2 = new float[HALF];
        System.arraycopy(array, 0, temArray1, 0, HALF);
        System.arraycopy(array, HALF, temArray2, 0, HALF);

        Thread t1 = new Thread(() -> {
            fillArray(temArray1, 0);
        });

        Thread t2 = new Thread(() -> {
            fillArray(temArray2, HALF);
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();


        System.arraycopy(temArray1, 0, array, 0, HALF);
        System.arraycopy(temArray2, 0, array, HALF, HALF);


    }

    private static void fillArray(float[] arrayToFill, int param) {
        for (int i = 0; i < arrayToFill.length; i++) {
            arrayToFill[i] = (float) (arrayToFill[i] * Math.sin(0.2f + (i + param) / 5) * Math.cos(0.2f + (i + param) / 5) *
                    Math.cos(0.4f + (i + param) / 2));

        }
    }

    private static void methodA(float[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (float) (array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) *
                    Math.cos(0.4f + i / 2));

        }
    }
}
