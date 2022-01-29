package ru.gb.model;

import ru.gb.interfaces.Conquerable;
import ru.gb.interfaces.Jumpable;

import java.util.Random;

public class Wall extends Barrier implements Jumpable {

    private Integer height;
    private static final String DEFAULT_NAME = "Wall";
    private static Integer count = 0;

    public Wall(Integer height) {
        super(DEFAULT_NAME + " " + (++count));
        this.height = height;
    }

    public Wall() {
        super(DEFAULT_NAME + " " + (++count));
        this.height = new Random().nextInt(20);
    }

    @Override
    public void jump(Jumpable jumpable) {
        jumpable.jump(this);
    }

    @Override
    public Integer getHeight() {
        return height;
    }

    @Override
    public void toPrevent(Conquerable conquerable) {
        jump((Jumpable) conquerable);
    }
}
