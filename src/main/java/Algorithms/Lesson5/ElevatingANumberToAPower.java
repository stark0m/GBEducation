/*1. Написать программу по возведению числа в степень с помощью рекурсии.*/

package Algorithms.Lesson5;

public class ElevatingANumberToAPower {
    public static void main(String[] args) {
        System.out.println(elevatingToAPawer(2,5));
    }

    private static double elevatingToAPawer(double num, int pow) {
        if(pow==0) {
            return 0;
        }
        if (pow==1) {
            return num;
        }
        if (pow<0) {
            pow = Math.abs(pow);
            num = 1.0 * 1 / num;
        }
        return num*elevatingToAPawer(num,pow-1);

    }
}
