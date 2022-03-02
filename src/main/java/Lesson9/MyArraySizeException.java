package Lesson9;

import java.io.IOException;

public class MyArraySizeException extends IOException {
    public MyArraySizeException() {
        super("Недопустимый размер входного массива, допускается только массив [4х4] String");
    }
}
