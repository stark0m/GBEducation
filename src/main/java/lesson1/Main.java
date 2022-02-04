package lesson1;

public class Main {
    public static void main(String[] args) {
        /*        printHelloWorld();*/

//        testVars();
        testAppraisal();
    }


    private static void testVars() {
//        perem
        int varA = 7;
        int varB = 3;
        long longA = 10000000000L;
        double doubleVarA = 9;
        float floatVar = 3.9f;
        int result = varA * varB;
        double resultD = 1.0 * varA / varB;
        resultD = (double) varA / varB;
        boolean isChanged = true;
        char chA = 1234;

        String helloStr = "hello";
        String worldStr = "World"; // конкотинация

//        Main
        System.out.println(chA);
        System.out.println(helloStr + " " + worldStr + (3 + 2));
    }

    static void printHelloWorld() {
        System.out.println("hello world");
    }

    private static void testAppraisal() {
        int appraisal = 6;
        System.out.println("Принесена оценка : " + appraisal);

        if (appraisal == 5) {
            System.out.println("принес 5");

        } else if (appraisal == 4) {
            System.out.println("ты можешь лучше");
        } else {
            System.out.println("говори правду!");
        }
        System.out.println("Проверка окончена");
    }

}
