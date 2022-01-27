package ru.gb.participants;

import ru.gb.interfaces.OverComable;
import ru.gb.interfaces.Particible;
import ru.gb.utils.UtilTote;

import java.util.Objects;
import java.util.Random;

public class Cat extends Animal implements Swimmable, Runnerble, Particible {

    private Integer swimmingDistance;
    private Integer runningDistance;
    private static final String DEFAULT_NAME = "Cat";

    private static Integer counterCat = 0;
    private Integer score = 0;
    private boolean isFinished = false;

    public Cat(String name, Integer swimmingDistance, Integer runningDistance) {
        super(name);
        this.swimmingDistance = new Random().nextInt(swimmingDistance);
        this.runningDistance = new Random().nextInt(runningDistance);
        counterCat++;
    }


    public Cat() {
        super(DEFAULT_NAME + " " + (++counterCat));
        this.swimmingDistance = UtilTote.getRandomNumberUsingNextInt(200, 2000);
        this.runningDistance = UtilTote.getRandomNumberUsingNextInt(200, 2000);
    }

    @Override
    public void running(Runnerble runnerble) {
        if(isFinished) {
            return;
        }
        var rDist = runnerble.getDistance();
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
        return "Cat{" +
                "Cat name: " + getName() +
                " swimmingDistance=" + swimmingDistance +
                ", runningDistance=" + runningDistance +
                ", score=" + score +
                ", isFinished=" + isFinished +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Cat cat = (Cat) o;
        return isFinished == cat.isFinished && Objects.equals(swimmingDistance, cat.swimmingDistance) && Objects.equals(runningDistance, cat.runningDistance) && Objects.equals(score, cat.score);
    }

    @Override
    public int hashCode() {
        return Objects.hash(swimmingDistance, runningDistance, score, isFinished);
    }
}
