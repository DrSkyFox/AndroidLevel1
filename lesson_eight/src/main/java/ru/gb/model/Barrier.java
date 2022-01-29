package ru.gb.model;

import ru.gb.interfaces.Conquerable;
import ru.gb.interfaces.Preventable;

import java.util.Objects;

public abstract class Barrier implements Preventable {

    private String name;

    public Barrier(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Barrier barrier = (Barrier) o;
        return Objects.equals(name, barrier.name);
    }

    @Override
    public void toPrevent(Conquerable conquerable) {
        // TODO: 30.01.2022
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Barrier{" +
                "name='" + name + '\'' +
                '}';
    }
}
