package ru.gb.model;

import ru.gb.interfaces.Jumpable;
import ru.gb.interfaces.Preventable;
import ru.gb.interfaces.Runner;

public class Human extends Participant{


    private static final String DEFAULT_NAME = "HUMAN";
    private static Integer count = 0;

    public Human(String name, int maxJump, int maxRun) {
        super(name, maxJump, maxRun);
    }

    public Human() {
        super(DEFAULT_NAME + " " + (++count));
    }

    @Override
    public void jump(Jumpable jumpable) {
        super.jump(jumpable);
    }

    @Override
    public void justDoIt(Preventable preventable) {
        super.justDoIt(preventable);
    }

    @Override
    public void run(Runner runner) {
        super.run(runner);
    }

}
