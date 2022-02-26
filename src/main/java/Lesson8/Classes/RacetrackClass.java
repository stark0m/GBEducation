package Lesson8.Classes;

import Lesson8.Interfaces.ObstacleInterface;
import Lesson8.ObstacleEnum;

import java.util.Random;

public class RacetrackClass implements ObstacleInterface {
    ObstacleEnum value;
    int distance;
    public RacetrackClass() {
        this.value = ObstacleEnum.DISTANCE;
        distance = (new Random().nextInt(30)+10)*10;
    }

    @Override
    public ObstacleEnum obstacle() {
        return value;
    }

    @Override
    public String type() {
        return "Беговая дорожка";
    }

    @Override
    public int obstacleSize() {
        return distance;
    }

    @Override
    public String toString() {
        return this.type() +                ", дистанция=" + distance ;
    }
}
