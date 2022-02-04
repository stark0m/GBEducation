package lesson2;

public class Main {
    public static void main(String[] args) {
        final int YEAR = 2016;
        System.out.println("Задание #1");
        System.out.println(GetABReturnTF(9, 4));
        System.out.println("Задание #2");
        GetAAndWrite(-18);
        System.out.println("Задание #3");
        System.out.println(GetAReturnTF(-19));
        System.out.println("Задание #4");
        GetStringANdLengthThenWrite("Hello world!", 5);
        System.out.println("Задание #5");
        boolean visokosnijGod = IsYearVisokos(YEAR);
        System.out.println("Год " + YEAR + " явлеяется високосным? :" + visokosnijGod);
    }


    private static boolean GetABReturnTF(int a, int b) {
        int sumAB = a + b;
        if (sumAB >= 10 && sumAB <= 20) return true;
        else return false;
    }

    private static void GetAAndWrite(int a) {

        if (a > 0) {
            System.out.println("Получено положительное значение");
        } else {
            System.out.println("Получено отрицательное значение");
        }
    }

    private static boolean GetAReturnTF(int a) {
        if (a > 0) {
            return true;
        } else {
            return false;
        }
    }

    private static void GetStringANdLengthThenWrite(String s, int l) {
        if (l <= 0) {
            System.out.println("число не может быть отрицательным");
            return;
        }
        for (int i = 0; i < l; i++) {
            System.out.println(s);

        }
    }

    private static boolean IsYearVisokos(int year) {
        int formatedYear = year;
        while (formatedYear > 400) {
//            System.out.println(formatedYear);
            formatedYear -= 400;

        }
        ;

        boolean result = true;
        switch (formatedYear) {
            case 100:
                result = false;
                break;
            case 200:
                result = false;
                break;
            case 300:
                result = false;
                break;
        }
        if (formatedYear % 4 != 0) {
            result = false;
        }
        if (!result) return result;
        return result;
    }


}



