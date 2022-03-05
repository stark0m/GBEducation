package Lesson10;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestClass {
    public static void main(String[] args) {
        MyList<Object> objectList = new MyList<>();
        objectList.add("5");

        objectList.add(6);
        objectList.add(5.13);
        objectList.add("ABC");
        System.out.println(objectList);


        System.out.println(objectList.swap("ABC", 5.13));
        System.out.println(objectList);


    }

}
