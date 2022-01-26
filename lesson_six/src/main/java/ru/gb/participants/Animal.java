package ru.gb.participants;

import java.util.Objects;

public abstract class Animal {

    private String name;
    private static Integer counter = 0;

    public Animal(String name) {
        this.name = name;
        counter++;
    }

    public String getName() {
        return name;
    }

    public static Integer getCounter() {
        return counter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(name, animal.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }


}
