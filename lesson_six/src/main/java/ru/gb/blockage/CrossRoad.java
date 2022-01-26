package ru.gb.blockage;

import ru.gb.interfaces.OverComable;
import ru.gb.interfaces.Particible;
import ru.gb.participants.Runnerble;
import ru.gb.utils.UtilTote;

import java.util.Objects;
import java.util.Random;

public class CrossRoad extends Track implements Runnerble, OverComable {

    private Integer length;
    private static final String DEFAULT_NAME = "Cross Road";


    public CrossRoad(String name, Integer length) {
        super(name);
        this.length = length;
    }

    public CrossRoad(Integer length) {
        super(DEFAULT_NAME);
        this.length = length;
    }

    public CrossRoad() {
        super(DEFAULT_NAME);
        this.length = UtilTote.getRandomNumberUsingNextInt(0, 1000);;
    }


    @Override
    public void running(Runnerble runnerble) {
        runnerble.running(this);
    }

    @Override
    public void justDoIt(Particible particible) {
        running((Runnerble) particible);
    }

    @Override
    public Integer getDistance() {
        return length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CrossRoad crossRoad = (CrossRoad) o;
        return Objects.equals(length, crossRoad.length);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), length);
    }

    @Override
    public String toString() {
        return "CrossRoad{" +
                "length=" + length +
                '}';
    }
}
