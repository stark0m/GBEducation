package Lesson8.Classes;

import Lesson8.Interfaces.ParticipantInterface;

import java.util.Random;

public class Cat implements ParticipantInterface {
    int canJump,canRunDistance;
    @Override
    public boolean jump(int heigth) {
        if (this.canJump>=heigth){
            System.out.println("Кот легко перепрыгивает препядствие " + heigth + "м");
            return true;
        }
            System.out.println("Кот не сможет перепрыгнуть это препядствие");
            return false;



    }

    @Override
    public boolean run(int distance) {
        if (this.canRunDistance>=distance){
            System.out.println("Кот пробежал по беговой дорожке " + distance + "м");
            return true;
        }
        System.out.println("Кот не способен пробежать такую дистанцию пробежал по беговой дорожке " + distance + "м");
        return false;

    }


    @Override
    public String participantType() {
        return "Кот";
    }
    @Override
    public String toString() {
        return participantType()+" - может подпрыгнуть на "+ canJump +"м. и может пробежать " + canRunDistance +"м.";
    }

    public Cat() {
        canJump = new Random().nextInt(2)+1;
        canRunDistance = (new Random().nextInt(10)+10)*10;
    }
}
