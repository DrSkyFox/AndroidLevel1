package ru.gb.interfaces;

public interface Conquerable {
    void justDoIt(Preventable preventable);
    Boolean hasStopped();
    Integer getCompletedStage();
}
