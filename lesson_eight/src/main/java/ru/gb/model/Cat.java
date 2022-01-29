package ru.gb.model;

import ru.gb.interfaces.Jumpable;
import ru.gb.interfaces.Preventable;
import ru.gb.interfaces.Runner;

public class Cat extends Participant{


    private static final String DEFAULT_NAME = "Cat";
    private static Integer count = 0;

    public Cat(String name, int maxJump, int maxRun) {
        super(name, maxJump, maxRun);
    }

    public Cat() {
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
