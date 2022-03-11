package Algorithms.Lesson6;

import java.util.Random;

public class TreeItem {
    Tree<Integer> value = new TreeImpl<Integer>();

    public TreeItem(int depth, int minValue,int maxValue) {
    while (value.depth()<=depth){
        this.value.add(new Random().nextInt(maxValue-minValue+1)+minValue);
    }


    }
}
