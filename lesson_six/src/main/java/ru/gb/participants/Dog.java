package ru.gb.participants;

import ru.gb.interfaces.OverComable;
import ru.gb.interfaces.Particible;
import ru.gb.utils.UtilTote;

import java.util.Objects;
import java.util.Random;

public class Dog extends Animal implements Swimmable, Runnerble, Particible {

    private static Integer counterDog = 0;
    private Integer swimmingDistance;
    private Integer runningDistance;
    private static final String DEFAULT_NAME = "DOG";

    private boolean isFinished = false;
    private Integer score = 0;


    public Dog(String name, Integer swimmingDistance, Integer runningDistance) {
        super(name);
        this.swimmingDistance = new Random().nextInt(swimmingDistance);
        this.runningDistance = new Random().nextInt(runningDistance);
        counterDog++;
    }

    public Dog() {
        super(DEFAULT_NAME + " "  + (++counterDog));
        this.swimmingDistance = UtilTote.getRandomNumberUsingNextInt(200, 2000);
        this.runningDistance = UtilTote.getRandomNumberUsingNextInt(200, 2000);
    }

    @Override
    public void running(Runnerble runnerble) {
        var rDist = runnerble.getDistance();
        if(isFinished) {
            return;
        }
        if (rDist > runningDistance) {
            System.out.println(this.getName() + " не пробежал препятсвие");
            isFinished = true;
        } else {
            runningDistance = runningDistance - rDist;
            System.out.println(this.getName() + " пробежал препятсвие. Осталось сил на забег" + runningDistance);
            score += rDist;
        }
    }


    @Override
    public void swimming(Swimmable swimmable) {
        if(isFinished) {
            return;
        }
        var rDist = swimmable.getDistance();
        if (rDist > swimmingDistance) {
            System.out.println(this.getName() + " не проплыл препятсвие");
            isFinished = true;
        } else {
            swimmingDistance = swimmingDistance - rDist;
            System.out.println(this.getName() + " проплыл препятсвие. Осталось сил на плавание" + swimmingDistance);
            score += rDist;
        }
    }

    @Override
    public void overcome(OverComable overComable) {
        overComable.justDoIt(this);
    }

    @Override
    public Integer getScore() {
        return score;
    }

    @Override
    public Integer getDistance() {
        return null;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "Dog name: " + getName() +
                " swimmingDistance=" + swimmingDistance +
                ", runningDistance=" + runningDistance +
                ", isFinished=" + isFinished +
                ", score=" + score +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Dog dog = (Dog) o;
        return isFinished == dog.isFinished && Objects.equals(swimmingDistance, dog.swimmingDistance) && Objects.equals(runningDistance, dog.runningDistance) && Objects.equals(score, dog.score);
    }

    @Override
    public int hashCode() {
        return Objects.hash(swimmingDistance, runningDistance, isFinished, score);
    }
}
