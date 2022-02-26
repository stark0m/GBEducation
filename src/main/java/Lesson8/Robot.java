package Lesson8;

public class Robot implements ParticipantInterface{
    @Override
    public void jump() {
        System.out.println("Робот перепрыгивает препядствие");
    }

    @Override
    public void run() {
        System.out.println("Робот пробежал дистанцию");
    }


}
