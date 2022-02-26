package Lesson8;

public class RacetrackClass implements ObstacleInterface{
    ObstacleEnum value;

    public RacetrackClass() {
        this.value = ObstacleEnum.DISTANCE;
    }

    @Override
    public ObstacleEnum obstacle() {
        return value;
    }
}
