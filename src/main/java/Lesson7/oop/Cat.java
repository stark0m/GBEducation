package Lesson7.oop;

import java.util.concurrent.ThreadLocalRandom;

public class Cat {
    private String name;
    private static final int IT_IS_FULL = 10;
    private int satiety;


    public String getName() {
        return name;
    }

    public int getSatiety() {
        return satiety;
    }

    public void setSatiety(int satiety) {
        this.satiety = satiety;
    }

    public Cat(String name) {
        this.name = name;
        this.setSatiety(ThreadLocalRandom.current().nextInt(IT_IS_FULL));
    }

    public void eat(Plate plate) {
        plate.decreaseFood(this);



    }
    public int needToBeFull (){
        return IT_IS_FULL-satiety;
    }

    public void ate() {
        setSatiety(IT_IS_FULL);
    }

    public boolean isFull() {
        return IT_IS_FULL==getSatiety();
    }

    public void printInfo() {
        System.out.printf("Кот %s сыт на %s из %s, он хочет сьесть %s еды%n",this.name,this.getSatiety(),IT_IS_FULL, needToBeFull());
    }
}
