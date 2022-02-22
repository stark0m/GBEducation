package Education;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class TestClass {
    public static void main(String[] args) {
       int e= new int [4][8].length;
        System.out.println(e);

        byte a= 127;
        a++;
        System.out.println(a);
        MyObject tt = new MyObject();

        System.out.println(MyObject.copyMyObject.temp );


    }
}

class MyObject {
    int temp;
    static MyObject copyMyObject = new MyObject();

    public MyObject() {
        this.temp = 1;
    }


}