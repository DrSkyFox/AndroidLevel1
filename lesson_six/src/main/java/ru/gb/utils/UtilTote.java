package ru.gb.utils;

import java.util.Random;

public final class UtilTote {

    public static int getRandomNumberUsingNextInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

}
