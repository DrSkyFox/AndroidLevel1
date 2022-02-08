package ru.nine;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        var arr = new MyExceptionIsMyProtection(4);
        Random random = new Random();

        String[][] matrix = generateMatrix(4,5, false);
        print(matrix);

        try {
            arr.setStrMat(matrix);
            System.out.println("Sum - " + arr.getSumOfAllElements());
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }



        matrix = generateMatrix(4,4, false);
        print(matrix);

        try {
            arr.setStrMat(matrix);
            System.out.println("Sum - " + arr.getSumOfAllElements());
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }


        matrix = generateMatrix(4,4, true);
        print(matrix);

        try {
            arr.setStrMat(matrix);
            System.out.println("Sum - " + arr.getSumOfAllElements());
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }



    }



    private static String[][] generateMatrix(int row, int col, boolean alpha) {
        String[][] temp = new String[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j <col; j++) {
                temp[i][j] = random(alpha);
            }
        }
        return temp;
    }


    private static void print(String[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j <mat[0].length; j++) {
                System.out.print(mat[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }


    /**
     * ASCII a-z .. 97 - 122 , num 48..57
     * @return string length of 1
     */
    private static String random(boolean alpha) {
        int start = 48;
        int stop = 122;
        Random random =new Random();
        if(alpha){
            return String.valueOf((char)  random.ints(start, stop+1)
                    .filter(value -> (value <= 57 || value >= 97)).findFirst().getAsInt()
            );
        }
        else {
            return String.valueOf((char)  random.ints(start, stop+1)
                    .filter(value -> (value <= 57)).findFirst().getAsInt()
            );
        }
    }

}
