package Lesson13;

import javax.naming.Context;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Car implements Runnable {
    private static int CARS_COUNT;
    private Race race;
    private int speed;
    private String name;
    private static CountDownLatch cdl;
    private static Semaphore semaphore;
    private static volatile boolean anybodyFinished = false;


    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;

        semaphore = new Semaphore(CARS_COUNT / 2);


    }

    public static void setCdl(CountDownLatch cdl) {
        Car.cdl = cdl;
    }

    @Override
    public void run() {
        try {

            try {
                System.out.println(this.name + " готовится");

                Thread.sleep(500 + (int) (Math.random() * 800));
                cdl.countDown();

                System.out.println(this.name + " готов");
                cdl.await();
            } catch (Exception e) {
                e.printStackTrace();
            }

            for (Stage stage : race.getStages()) {

                stage.go(this, semaphore);


            }
            if (!anybodyFinished) {
                anybodyFinished = true;
                System.out.println(this.name + " WIN");
            }
        } finally {
            cdl.countDown();
        }
    }
}
