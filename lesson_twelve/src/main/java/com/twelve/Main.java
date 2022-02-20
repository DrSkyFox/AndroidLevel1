package com.twelve;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws NoSuchMethodException {

        float[] arr = new float[100000000];
        List<Long> longs = new ArrayList<>();

        ArrayRunner myArray = new ArrayRunner(2);
        longs.add(myArray.timeOperation(ArrayRunner.class.getMethod("fillArrayOnes", float[].class), arr));

        arr = null;
        arr = new float[100000000];
        longs.add(myArray.timeOperation(ArrayRunner.class.getMethod("fillArrayOnesThread", float[].class), arr));

        arr = null;
        arr = new float[100000000];
        longs.add(myArray.timeOperation(ArrayRunner.class.getMethod("fillArrayWithMath", float[].class), arr));

        arr = null;
        arr = new float[100000000];
        longs.add(myArray.timeOperation(ArrayRunner.class.getMethod("fillArrayWithMathThreads", float[].class), arr));


        for (Long aLong :
                longs) {
            System.out.println("Result of runnings: " + aLong);
        }
    }


}
