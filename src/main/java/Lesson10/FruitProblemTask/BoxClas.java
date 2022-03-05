package Lesson10.FruitProblemTask;

import java.util.ArrayList;
import java.util.Stack;

public class BoxClas<E extends Fruit> extends Stack<E> {
    private double weight = 0;

    public double getWeight() {
        return weight;
    }

    @Override
    public boolean add(E e) {
        super.add(e);
        if (e instanceof Fruit) {


            weight += e.getWeight();
        }
        return true;

    }



    @Override
    public synchronized E pop() {
        E result= super.pop();
        if (result!=null){

            weight-=result.getWeight();
        }

        return result;
    }

    public E getFruit(){
        if (!this.isEmpty()) {
            return this.pop();
        }else {
            System.out.println("Эта коробка пустая");
            return null;
        }
    }

    public boolean compareBoxWeight(BoxClas<?> box){
        return Math.abs(this.getWeight()- box.getWeight())<0.01;
    }
    public void transferFruitsToAnotherBox(BoxClas<E> box, int count){
        int canTransfer = count;
        if (count>this.size()){
            count = this.size();
        }
        for (int i = 0; i < count; i++) {
            box.add(this.pop());

        }

    }
}
