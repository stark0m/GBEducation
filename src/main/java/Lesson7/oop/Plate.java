package Lesson7.oop;

public class Plate {
    private int foodCount;

    public Plate(int foodCount) {

        this.foodCount = foodCount;
    }

    public void printInfo() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Plate{" + "foodCount=" + foodCount + '}';
    }

    public void addFood(int count){
        foodCount+=count;
    }
    public void decreaseFood(Cat cat)
    {
        if (this.isEmpty()){
            System.out.println("В этой тарелке больше нет еды");
            return;
        }
        int needToEat = cat.needToBeFull();
        if (foodCount>=needToEat) {
            foodCount -=needToEat;
            cat.ate();
            System.out.println("Кот "+cat.getName()+" полностью наелся");
        } else {
            int canToEat = foodCount;
            foodCount = 0;
            cat.setSatiety(cat.getSatiety()+canToEat);
            System.out.println("Кот "+cat.getName()+" сьел всю еду из тарелки но не наелся ");
            cat.printInfo();
        }

    }

    private boolean isEmpty() {
        return foodCount==0;
    }

    public int getFoodCount() {
        return foodCount;
    }
}
