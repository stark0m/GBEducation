package Lesson8;

public class Cat implements ParticipantInterface{
    @Override
    public void jump() {
        System.out.println("Кот легко перепрыгивает препядствие");
    }

    @Override
    public void run() {
        System.out.println("Кот пробежал по беговой дорожке");
    }


}
