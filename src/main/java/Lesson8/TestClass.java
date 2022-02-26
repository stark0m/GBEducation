package Lesson8;

import Lesson8.Classes.*;
import Lesson8.Interfaces.ObstacleInterface;
import Lesson8.Interfaces.ParticipantInterface;

import java.util.Random;

public class TestClass {
    public static void main(String[] args) {

//        ParticipantInterface humain = new Humain();
//        ParticipantInterface robot = new Robot();
//
//        ObstacleInterface wall = new WallClass();
//        ObstacleInterface racetrack = new RacetrackClass();
//
//        humain.action(wall);
//        robot.action(racetrack);
        final int PARTICIPANTS_COUNT = 10;
        final int OBSTACLE_COUNT = 5;

        ParticipantInterface[] arrayParticipant = new ParticipantInterface[PARTICIPANTS_COUNT];
        ObstacleInterface[] obstacleArray = new ObstacleInterface[OBSTACLE_COUNT];

        genAndSwowParticipantArray(arrayParticipant);
        genAndShowObstacleArray(obstacleArray);


        System.out.println("Соревнования начались");
        int participantNumber=0;
        for (ParticipantInterface participant : arrayParticipant) {
            System.out.println("=================================== "+ ++participantNumber + ". "+participant+" ===================================");

        int obstacleNumber = 0;
            for (ObstacleInterface obstacle : obstacleArray) {
                System.out.print(++obstacleNumber + ". ");
                System.out.println(obstacle);

                if (!participant.action(obstacle)){
                    System.out.println("Этот участник не справился и покидает соревнования!!!!!");
                    break;
                };

            }

        }

    }

    private static void genAndShowObstacleArray(ObstacleInterface[] obstacleArray) {
        System.out.println("Создаем полосу препядствий");
        System.out.print("[ ");
        for (int i = 0; i < obstacleArray.length; i++) {
            obstacleArray[i] =  RandomObstcle();
            System.out.printf("(%s. %s) ",i+1,obstacleArray[i].toString());
        }
        System.out.println("]");
    }

    private static ObstacleInterface RandomObstcle() {
        return (new Random().nextInt(11)>5) ? new RacetrackClass() : new WallClass();
    }

    private static void genAndSwowParticipantArray(ParticipantInterface[] arrayParticipant) {
        System.out.println("Генерируем массив участников");
        System.out.print("[ ");
        for (int i = 0; i < arrayParticipant.length; i++) {
            arrayParticipant[i] =  RandomParticipant();
            System.out.printf("(%s. %s) ",i+1,arrayParticipant[i].toString());
        }
        System.out.println("]");

    }

    private static ParticipantInterface RandomParticipant() {
        switch (new Random().nextInt(3)+1){
            case  1 : return new Cat();
            case  2 : return new Humain();
            default: return new Robot();

        }
    }
}
