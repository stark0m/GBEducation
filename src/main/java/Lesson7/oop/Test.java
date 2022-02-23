package Lesson7.oop;

import java.util.Random;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        String[] catName = new String[]{"Барсик", "Васька","Кокос","Космос","Белка","Стрелка","Беляш"};
        final int CAT_COUNT= 100;
        final int EAT_COUNT= 100;
        Cat[] catArray = new Cat[CAT_COUNT];


        for (int i = 0; i < CAT_COUNT; i++) {
            catArray[i] = new Cat(catName[new Random().nextInt(catName.length)]);

        }


        Plate plate = new Plate(EAT_COUNT);

        plate.printInfo();

        for (Cat cat : catArray) {
            if (cat.isFull()) {
                continue;
            }
        cat.printInfo();
            cat.eat(plate);
            while (!cat.isFull()){
                System.out.println("Коты еще не наелись, а еда уже закончилась, срочно добавим еды в тарелку!");
                plate.addFood(new Random().nextInt(50));
                plate.printInfo();
                cat.eat(plate);
            }
            plate.printInfo();
        }

    }
}