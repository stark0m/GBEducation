package Lesson8.Classes;

import Lesson8.Interfaces.ParticipantInterface;

import java.util.Random;

public class Humain implements ParticipantInterface {
    int canJump,canRunDistance;
    @Override
    public boolean jump(int arg) {
        if (this.canJump>=arg){
            System.out.println("Человек перепрыгнул препядтсвие " + arg +"m");
            return true;
        }
        System.out.println("Этот человек не сможет перепрыгнуть препядтсвие " + arg +"m");

        return false;



    }

    @Override
    public boolean run(int arg) {
        if (this.canRunDistance>=arg){
            System.out.println("Человек преодолел дистанцию " + arg +"m");
            return true;
        }
        System.out.println("Этот человек не сможет пробежать " + arg +"m");

        return false;


    }


    @Override
    public String participantType() {
        return "Человек";
    }

    public Humain() {
        canJump = new Random().nextInt(3)+1;
        canRunDistance = (new Random().nextInt(20)+10)*10;
    }

    @Override
    public String toString() {
        return participantType()+" - может подпрыгнуть на "+ canJump +"м. и может пробежать " + canRunDistance +"м.";
    }
}
