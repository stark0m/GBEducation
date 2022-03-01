/*2. Написать программу «Задача о рюкзаке» с помощью рекурсии.*/
package Algorithms.Lesson5;

public class Lesson5Test {
    public static final int CAPACITY_WEIGTH = 6;
    public static BackPackItemList bestChoise = new BackPackItemList(CAPACITY_WEIGTH);
    public static BackPackItemList backPack = new BackPackItemList(CAPACITY_WEIGTH);

    public static void main(String[] args) {



        backPack.add(new BackPackItem("Ноутбук",3,500));
        backPack.add(new BackPackItem("Тетрадь",1,30));
        backPack.add(new BackPackItem("Мяч",1,10));
        backPack.add(new BackPackItem("Гиря",3,10));
        backPack.add(new BackPackItem("Телефон",2,70));


        System.out.println("Есть этот набор вещей (Название/цена/вес)");
        System.out.println(backPack);


        bestChoise = backPackProblemTask(backPack);


        System.out.println("Решением задачи о рюкзаке с грузоподьемностью "+ CAPACITY_WEIGTH+" будет набор следующих предметов");
        System.out.println(bestChoise);
    }

    private static BackPackItemList backPackProblemTask(BackPackItemList backPack) {


        if (backPack.weigthSum()<=backPack.capacityMaxWeigth) {
          /*  System.out.println("Решение" + backPack + "цена лучшего содержимого рюкзака="+backPack.priceSum());
            System.out.println("Лучшее решение на данный момент" + backPack.getBestBackPackPrice(bestChoise) + "цена лучшего содержимого рюкзака="+backPack.getBestBackPackPrice(bestChoise).priceSum());*/
            bestChoise = backPack.getBestBackPackPrice(bestChoise);
            return bestChoise;
        } else {
            for (BackPackItem backPackItem : backPack) {
               BackPackItemList iterBPList = new BackPackItemList(backPack,CAPACITY_WEIGTH);
               iterBPList.remove(backPackItem);
//                System.out.println("углубдяемся "+iterBPList.getBestBackPackPrice(bestChoise));
               backPackProblemTask(iterBPList);
            }
        }
        return bestChoise;
    }


}
