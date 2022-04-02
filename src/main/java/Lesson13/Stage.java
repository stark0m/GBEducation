package Lesson13;

import java.util.concurrent.Semaphore;

public abstract class Stage {
    protected int length;
    protected String description;

    public String getDescription() {
        return description;
    }

    public abstract void go(Car c);
    public abstract void go(Car c, Semaphore sem);
}
