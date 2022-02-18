package Lesson6;

public abstract class Animal {
    public abstract void run(int distance);
    private static int totalAnimalBorn=0;
    public abstract void swim(int distance);

    private String animalTitle;

    public boolean canRun(int distance, int MAX_DISTANCE) {
        return (distance > 0 && distance <= MAX_DISTANCE);
    }

    public boolean canSwim(int distance, int MAX_DISTANCE) {
        return (distance > 0 && distance <= MAX_DISTANCE);
    }

    public Animal() {
        totalAnimalBorn++;
    }

    public static int getTotalAnimalBorn() {
        return totalAnimalBorn;
    }

    public String getAnimalTitle() {
        return animalTitle;
    }

    public void setAnimalTitle(String animalTitle) {
        this.animalTitle = animalTitle;
    }
}
