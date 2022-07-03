package com.fourteen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

public class MyArrayProcessing {

    private int[] arrayPost;
    private static final Logger log = Logger.getLogger(MyArrayProcessing.class.getName());

    public MyArrayProcessing() {
    }

    public int[] getArrayPostProcessing(int ... array) {
        int index = getIndex(array);
        if(index == 0) {
            throw new FourInArrayNotFoundException();
        }

        int size = array.length - 1 - index;

        int[] temp = new int[size];
        int j = 0;
        for (int i = index + 1; i < array.length; i++) {
            temp[j] = array[i];
            j++;
        }
        return temp;
    }

    public boolean check(int ... arrayPost) {
        if (getIndex(arrayPost) == 0) {
            return false;
        } else {
            return true;
        }
    }

    private int getIndex(int[] array) {
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 4) {
                index = i;
                break;
            }
        }
        return index;
    }



}
