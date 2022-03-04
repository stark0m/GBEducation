package Algorithms.Lesson5;

import java.util.ArrayList;
import java.util.Collection;


public class BackPackItemList extends ArrayList<BackPackItem>  {
 int capacityMaxWeigth;

    public BackPackItemList( int capacityWeigth) {
        super();
        this.capacityMaxWeigth = capacityWeigth;
    }

    public int weigthSum(){
        int result=0;
        BackPackItem temp;

        for (BackPackItem bpItem :this ) {
            result+=bpItem.getWeight();

        }
        return result;
    }
    public int priceSum(){
        int result=0;
        BackPackItem temp;

        for (BackPackItem bpItem :this ) {
            result+=bpItem.getPrice();

        }
        return result;
    }

    @Override
        public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Содержимое : [");
        for (BackPackItem item : this) {
            result.append(item);
        }
        result.append("]");
        return result.toString();
    }


    public BackPackItemList(Collection<? extends BackPackItem> c, int capacityMaxWeigth) {
        super(c);
        this.capacityMaxWeigth = capacityMaxWeigth;
    }

    public BackPackItemList getBestBackPackPrice(BackPackItemList bpItemList) {


        return (this.priceSum()> bpItemList.priceSum())?this:bpItemList;
    }
}
