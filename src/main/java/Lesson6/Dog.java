package Lesson6;

public class Dog extends Animal{

    private final int MAX_RUN_DISTANCE = 500;
    private final int MAX_SWIM_DISTANCE =10;
    private final String TITLE= "Собака";
    private static int totalDogsBorn = 0;


    public static int getTotalAnimalBorn() {
        return totalDogsBorn;
    }
    public Dog() {
        totalDogsBorn++;
        this.setAnimalTitle(TITLE);
    }

    @Override
    public void run(int distance) {
        if (this.canRun(distance,MAX_RUN_DISTANCE)) {
            System.out.println("Собака пробежала "+distance+" метров");
        } else {
            System.out.println("Собака не может пробежать дистанцию "+distance+ " метров");
        }
    }

    @Override
    public void swim(int distance) {
        if (this.canSwim(distance,MAX_SWIM_DISTANCE)) {
            System.out.println("Собака проплыла "+distance+" метров");
        } else {
            System.out.println("Собака плавает на  дистанцию "+distance+ " метров");
        }

    }


}
