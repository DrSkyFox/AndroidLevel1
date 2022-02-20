package com.lesson;

import java.util.concurrent.atomic.AtomicInteger;

public class Car implements Runnable {

    private static int CARS_COUNT;
    private Race race;
    private int speed;
    private String name;
    private static AtomicInteger racePosition = new AtomicInteger(0);
    private Integer positionFinished;

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
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        if(racePosition.getAndIncrement() == 0) {
            System.out.println(name + " закончил гонку первым");
            positionFinished = racePosition.get();
        } else {
            positionFinished = racePosition.get();
            System.out.println(name + "закончил гонку " + positionFinished);
        }

    }


}
