package Algorithms.Lesson6;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static final int TREE_COUNT = 100;

    public static void main(String[] args) {

        Tree<Integer> tree = new TreeImpl<>();

       /* tree.add(60);
        tree.add(50);
        tree.add(66);
        tree.add(40);
        tree.add(55);
        tree.add(70);
        tree.add(31);
        tree.add(45);
        tree.add(42);
        tree.add(43);
        tree.add(69);
        tree.add(67);
        tree.add(68);
        tree.add(81);

        tree.add(10);
        tree.add(5);
        tree.add(6);
        tree.add(3);
        tree.add(12);
        tree.add(11);
        tree.add(13);
        tree.add(14);
        tree.add(1);
        tree.add(4);

        tree.display();*/

//        tree.remove(40);

//        tree.display();
//
       /* tree.traverse(Tree.TraversMode.IN_ORDER);
        tree.traverse(Tree.TraversMode.PRE_ORDER);
        tree.traverse(Tree.TraversMode.POST_ORDER);
        tree.traverse(Tree.TraversMode.CHECK_BALANCE);
        System.out.println(tree.depth());*/

        TreeItem[] treeArray = new TreeItem[TREE_COUNT];
        int countBalancedTree = 0;

        for (int i = 0; i < TREE_COUNT; i++) {
            treeArray[i] = new TreeItem(4,-25,25);
            treeArray[i].value.display();
            treeArray[i].value.traverse(Tree.TraversMode.CHECK_BALANCE);
            if (treeArray[i].value.isBalancedInfo()) {
                countBalancedTree++;
            }

        }
        System.out.println("Всего сгенерированно " + TREE_COUNT + " деревьев");
        System.out.println("Из них сбалансированных "+ countBalancedTree);
        System.out.println("Таким образом " +(int)((1.0*countBalancedTree/TREE_COUNT)*100)+"% сгенерированных деревьев сбалансированны");


    }
}
