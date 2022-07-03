package com.fourteen;

public class Main {

    public static void main(String[] args) {
        var processing = new  MyArrayProcessing();
        int[] array = new int[] {
          1,2,3,4,5,6
        };

        var tt = processing.getArrayPostProcessing(array);
        print(tt);
    }

    public static void print(int [] tt) {
        for (int i = 0; i < tt.length; i++) {
            System.out.println(tt[i]);
        }
    }

}
