package Lesson6;

public class Cat extends Animal{
    private final int MAX_RUN_DISTANCE = 200;
    private final String TITLE= "Кот";
    private static int totalCatBorn=0;

    public Cat() {
        totalCatBorn++;
        this.setAnimalTitle(TITLE);
    }
    public static int getTotalAnimalBorn() {
        return totalCatBorn;
    }

    @Override
    public void run(int distance) {
        if (this.canRun(distance,MAX_RUN_DISTANCE)) {
            System.out.println("Кот пробежал "+distance+" метров");
        } else {
            System.out.println("Коту тяжело сразу прбежать "+distance+ " метров");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println("Коты не умеют плавать , а вы просите проплыть "+ distance + " метров");
    }
}
