package ru.gb.model;

import ru.gb.interfaces.Conquerable;
import ru.gb.interfaces.Runner;

import java.util.Random;

public class CrossWay extends Barrier implements Runner {

    private Integer distance;
    private static final String DEFAULT_NAME = "CrossWay";
    private static Integer count = 0;

    public CrossWay(Integer distance) {
        super(DEFAULT_NAME + " " + (++count));
        this.distance = distance;
    }

    public CrossWay() {
        super(DEFAULT_NAME + " " + (++count));
        this.distance = new Random().nextInt(500);
    }

    @Override
    public void run(Runner runner) {
        runner.run(this);
    }

    @Override
    public Integer getDistance() {
        return distance;
    }

    @Override
    public void toPrevent(Conquerable conquerable) {
        run((Runner) conquerable);
    }
}
