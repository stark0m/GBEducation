package Lesson8.Interfaces;

public interface ParticipantInterface<E> extends Runnable,JumperInterface{
    String participantType();



    default boolean action(ObstacleInterface obs){
        switch (obs.obstacle()){
            case WALL -> {
                return this.jump(obs.obstacleSize());
            }
            case DISTANCE -> {
                return this.run(obs.obstacleSize());
            }
        }
     return false;
    }


}
