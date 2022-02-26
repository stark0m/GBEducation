package Lesson8;

public class Humain implements ParticipantInterface{
    @Override
    public void jump() {
        System.out.println("Человек перепрыгнул препядтсвие");
    }

    @Override
    public void run() {
        System.out.println("Человек преодолел дистанцию");

    }


}
