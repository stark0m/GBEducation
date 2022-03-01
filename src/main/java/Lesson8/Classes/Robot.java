package Lesson8.Classes;

import Lesson8.Interfaces.ParticipantInterface;

import java.util.Random;

public class Robot implements ParticipantInterface {
    int canJump,canRunDistance;

    public Robot() {
        canJump = new Random().nextInt(7)+2;
        canRunDistance = (new Random().nextInt(40)+10)*10;
    }

    @Override
    public boolean jump(int arg) {
        if (this.canJump>=arg){
            System.out.println("Робот перпрыгнул препядствие " + arg +"m");
            return true;
        }
        System.out.println("Этот робот не сможет перепрыгнуть препядствие " + arg +"m");

        return false;
    }

    @Override
    public boolean run(int arg) {
        if (this.canRunDistance>=arg){
            System.out.println("Робот пробежал дистанцию " + arg +"m");
            return true;
        }
        System.out.println("Этот робот не сможет пробежать " + arg +"m");

        return false;


    }


    @Override
    public String participantType() {
        return "Робот";
    }
    @Override
    public String toString() {
        return participantType()+" - может подпрыгнуть на "+ canJump +"м. и может пробежать " + canRunDistance +"м.";
    }
}
