package Lesson8;

public class WallClass implements ObstacleInterface{
    ObstacleEnum value;

    public WallClass() {
        this.value = ObstacleEnum.WALL;
    }

    @Override
    public ObstacleEnum obstacle() {
        return value;
    }
}
