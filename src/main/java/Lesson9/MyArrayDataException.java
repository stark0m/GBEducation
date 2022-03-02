package Lesson9;

import java.io.IOException;

public class MyArrayDataException extends NumberFormatException {
    public MyArrayDataException(String s) {
        super("s");
    }

    public MyArrayDataException(int x, int y, String string) {
        super(String.format("Значение (%s) из массива в ячейке с координатами [%s,%s] нельзя привести к числу",string,x,y));
    }
}
