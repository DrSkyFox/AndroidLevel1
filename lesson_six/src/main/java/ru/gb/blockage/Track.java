package ru.gb.blockage;

import java.util.Objects;

public abstract class Track {


    private String name;
    private static Integer counter = 0;

    public Track(String name) {
        this.name = name;
        counter ++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Integer getCounter() {
        return counter;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Track track = (Track) o;
        return Objects.equals(name, track.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Track{" +
                "name='" + name + '\'' +
                '}';
    }
}
