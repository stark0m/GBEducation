package Lesson11;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Main {

    static private List<String> strings = Arrays.asList("Hello","world","and","peoples","Hello","world","any","skill,","any","skill","skill","skill","peoples" +
            "");

    public static void main(String[] args) {


    checkDublicates();



    }

    private static void checkDublicates() {
        strings.stream().distinct().forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s + " встречается "
                        + strings.stream().filter(s::equals).count()
                        +" раз");
                ;

            }
        });
    }
}
