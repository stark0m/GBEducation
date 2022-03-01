package Lesson8.Classes;

import Lesson8.Interfaces.ObstacleInterface;
import Lesson8.ObstacleEnum;

import java.util.Random;

public class WallClass implements ObstacleInterface {
    ObstacleEnum value;
    private int obscaleSize;

    public int getObscaleSize() {
        return obscaleSize;
    }

    public void setObscaleSize(int obscaleSize) {
        this.obscaleSize = obscaleSize;
    }

    public WallClass() {
        setObscaleSize(new Random().nextInt(4)+1);
        this.value = ObstacleEnum.WALL;
    }

    @Override
    public ObstacleEnum obstacle() {
        return value;
    }

    @Override
    public String type() {
        return "Стена";
    }

    @Override
    public int obstacleSize() {
        return obscaleSize;
    }

    @Override
    public String toString() {
        return this.type() +                ", высота=" + obscaleSize ;
    }
}
