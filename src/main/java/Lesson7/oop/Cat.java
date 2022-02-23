package Lesson7.oop;

import java.util.concurrent.ThreadLocalRandom;

public class Cat {
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    public void eat(Plate plate) {
        plate.decreaseFood(ThreadLocalRandom.current().nextInt(4) + 3);

        //toDo
    }
}
