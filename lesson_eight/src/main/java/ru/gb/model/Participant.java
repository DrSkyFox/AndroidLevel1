package ru.gb.model;

import ru.gb.interfaces.Conquerable;
import ru.gb.interfaces.Jumpable;
import ru.gb.interfaces.Preventable;
import ru.gb.interfaces.Runner;

import java.util.Comparator;
import java.util.Objects;
import java.util.Random;

public abstract class Participant implements Conquerable, Runner, Jumpable, Comparable<Participant>, Comparator<Participant> {
    private String name;
    private int maxJump;
    private int maxRun;
    private Boolean isStopped = false;
    private Integer stageComplete = 0;

    public Participant(String name, int maxJump, int maxRun) {
        this.name = name;
        this.maxJump = maxJump;
        this.maxRun = maxRun;
    }

    public Participant(String name) {
        Random random = new Random();
        this.name = name;
        this.maxJump = random.nextInt(20);
        this.maxRun = random.nextInt(500);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxJump() {
        return maxJump;
    }

    public void setMaxJump(int maxJump) {
        this.maxJump = maxJump;
    }

    public int getMaxRun() {
        return maxRun;
    }

    public void setMaxRun(int maxRun) {
        this.maxRun = maxRun;
    }

    @Override
    public void justDoIt(Preventable preventable) {
        preventable.toPrevent(this);
    }

    @Override
    public Boolean hasStopped() {
        return isStopped;
    }

    @Override
    public void jump(Jumpable jumpable) {
        if(isStopped) {
            return;
        }
        var targetHeight = jumpable.getHeight();
        if(targetHeight > getMaxJump()) {
            System.out.println(getName() +" не удалось перепрыгнуть");
            isStopped = true;
        } else {
            System.out.println(getName() + " успешно перепрыгнул");
            stageComplete++;
        }
    }

    @Override
    public void run(Runner runner) {
        if(isStopped) {
            return;
        }
        var targetDistance = runner.getDistance();
        if(targetDistance > getMaxRun()) {
            System.out.println(getName() +" не удалось пробежать");
            isStopped = true;
        } else {
            System.out.println(getName() + " успешно пробежал");
            stageComplete ++;
        }
    }

    @Override
    public Integer getCompletedStage() {
        return stageComplete;
    }

    @Override
    public Integer getHeight() {
        return null;
    }

    @Override
    public Integer getDistance() {
        return null;
    }

    @Override
    public int compareTo(Participant o) {
        if(this.stageComplete > o.getCompletedStage()) {
            return 1;
        } else if(this.stageComplete < o.getCompletedStage()) {
            return -1;
        } else return 0;
    }

    @Override
    public int compare(Participant o1, Participant o2) {
        if(o1.getCompletedStage() > o2.getCompletedStage()) {
            return 1;
        }else if(o1.getCompletedStage() < o2.getCompletedStage()) {
            return -1;
        } else return 0;
    }

    @Override
    public String toString() {
        return "Participant{" +
                "name='" + name + '\'' +
                ", maxJump=" + maxJump +
                ", maxRun=" + maxRun +
                ", stageComplete=" + stageComplete +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participant that = (Participant) o;
        return maxJump == that.maxJump && maxRun == that.maxRun && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, maxJump, maxRun);
    }
}
