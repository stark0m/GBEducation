package Lesson8;

import java.util.Iterator;

public interface ParticipantInterface<E> extends Runnable,JumperInterface{
    default void action(ObstacleInterface obs){
        switch (obs.obstacle()){
            case WALL -> this.jump();
            case DISTANCE -> this.run();
        }
    }
}
