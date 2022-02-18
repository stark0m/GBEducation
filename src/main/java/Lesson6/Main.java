package Lesson6;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static final int ANIMALS_COUNT = 10;
    public static List<Animal> animals = new ArrayList<>();

    public static boolean isAnimalCouldBeBorn() {
        Random rnd = new Random();
        return rnd.nextBoolean();
    }

    public static void generateAnimalBorn(int count) {
        for (int i = 0; i < count; i++) {
            if (isAnimalCouldBeBorn()) {
                animals.add(new Cat());
            } else {
                if (isAnimalCouldBeBorn()) {
                    animals.add(new Dog());
                }
            }

        }
    }

    public static void main(String[] args) {

        generateAnimalBorn(ANIMALS_COUNT);
        System.out.println("Должно родиться " + ANIMALS_COUNT + " животных");
        System.out.println("Всего родилось " + Animal.getTotalAnimalBorn() + " животных");
        System.out.println("Из них " + Dog.getTotalAnimalBorn() + " собак, и " + Cat.getTotalAnimalBorn() + " котов");


        for (Animal animal : animals) {
            Random rnd = new Random();
            System.out.println("-------------------");
            System.out.println(animals.indexOf(animal)+1+" животное "+ animal.getAnimalTitle());
            animal.run(rnd.nextInt(800));
            animal.swim(rnd.nextInt(20));

        }


    }
}
