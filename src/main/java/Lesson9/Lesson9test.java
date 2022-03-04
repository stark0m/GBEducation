package Lesson9;

import java.io.IOException;

public class Lesson9test {
    public static final int STRINGS_SIZE = 4;
    public static String[][] stringsXY = {{"1","5","3","44"},{"1","2","3","4"},{"1","2","3","4"},{"1","2","3","4"}};
//      public static String[][] stringsXY = {{"1","5","3"},{"1","3","4"},{"2","3","4"},{"2","3","4"}};

    public static void main(String[] args) {


        try {
            System.out.println("Сумма чисел в предоставленном массиве="+testArray(stringsXY));
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        }


    }

    private static int testArray(String[][] stringsXY) throws MyArraySizeException {



        if (stringsXY.length != 4 || stringsXY[0].length != 4) {
            throw new MyArraySizeException();
        }

        int result = 0;
        int x = 0;

        for (String[] strings : stringsXY) {
            int y = 0;
            for (String s : strings) {

                try  {
                      result += Integer.parseInt(s);
                } catch ( NumberFormatException e){
                    throw new  MyArrayDataException(x,y,s);

                }
                        y++;
            }
            x++;

        }
        return result;
    }
}
