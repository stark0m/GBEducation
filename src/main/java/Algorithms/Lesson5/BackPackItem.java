package Algorithms.Lesson5;

public class BackPackItem {
    int weight;
    int price;
    String title;

    @Override
    public String toString() {
        return "(" +title +"/"+price +"/"+weight+")";
    }

    public BackPackItem(String title, int weight, int price) {
        this.weight = weight;
        this.price = price;
        this.title = title;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
