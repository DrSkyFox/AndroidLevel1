package ru.gb.blockage;

import ru.gb.interfaces.OverComable;
import ru.gb.interfaces.Particible;

import ru.gb.participants.Swimmable;
import ru.gb.utils.UtilTote;

import java.util.Objects;
import java.util.Random;

public class SwimmingPool extends Track implements Swimmable, OverComable {

    private Integer length;
    private static final String DEFAULT_NAME = "Swimming Pool";

    public SwimmingPool(String name, Integer length) {
        super(name);
        this.length = length;
    }

    public SwimmingPool(Integer length) {
        super(DEFAULT_NAME +  " " + getCounter());
        this.length = length;
    }

    public SwimmingPool() {
        super(DEFAULT_NAME );
        this.length = UtilTote.getRandomNumberUsingNextInt(0, 1000);
    }

    @Override
    public void swimming(Swimmable swimmable) {
        swimmable.swimming(this);
    }

    @Override
    public void justDoIt(Particible particible) {
        swimming((Swimmable) particible);
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
        SwimmingPool that = (SwimmingPool) o;
        return Objects.equals(length, that.length);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), length);
    }

    @Override
    public String toString() {
        return "SwimmingPool{" +
                "length=" + length +
                '}';
    }
}
