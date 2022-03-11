package Lesson10.FruitProblemTask;

public class test {
    public static void main(String[] args) {

        BoxClas<Apple> appleBox = new BoxClas<Apple>();
        BoxClas<Orange> orangeBox = new BoxClas<>();
        BoxClas<Orange> orangeBox2 = new BoxClas<>();

        appleBox.add(new Apple());
        appleBox.add(new Apple());
        appleBox.add(new Apple());
        appleBox.add(new Apple());
        appleBox.add(new Apple());
        appleBox.add(new Apple());


        orangeBox.add(new Orange());
        orangeBox.add(new Orange());
        orangeBox.add(new Orange());
        orangeBox.add(new Orange());
        orangeBox.add(new Orange());
        orangeBox.add(new Orange());
        orangeBox.add(new Orange());

        System.out.println("накладываем яблоки и апельсины в коробки, в итоге");

        System.out.println("Коробка с яблоками весит " + appleBox.getWeight());

        System.out.println("1 Коробка с апельсинами весит " + orangeBox.getWeight());
        System.out.println("2 Коробка с апельсинами весит " + orangeBox2.getWeight());
        System.out.println("Перекладываем 3 апельсина из 1 коробки с апельсинами во 2 коробку");

        orangeBox.transferFruitsToAnotherBox(orangeBox2, 3);
        System.out.println("1 Коробка с апельсинами весит " + orangeBox.getWeight());
        System.out.println("2 Коробка с апельсинами весит " + orangeBox2.getWeight());


        System.out.println("Сравниваем вес коробки с яблоками и 1 коробки с апельсинами");
        if (orangeBox.compareBoxWeight(appleBox)) {
            System.out.println("Коробки весят одинаково");
        } else {
            System.out.println("Вес коробок отличается");
        }

        System.out.println("Пробуем из достать из 2 коробки с апельсинами взять 5 апельсинов");
        for (int i = 0; i < 5; i++) {
            if (orangeBox2.getFruit() != null) {
                System.out.println("Взяли аппельсин");
            }


        }
        System.out.println("2 Коробка с апельсинами весит " + orangeBox2.getWeight());


    }
}
