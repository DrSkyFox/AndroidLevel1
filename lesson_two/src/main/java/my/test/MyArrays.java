package my.test;

import java.util.Arrays;


public class MyArrays {


    private int [] array;
    private int sizeArray;

    public MyArrays(int sizeArray, int min, int max) {
        this.sizeArray = sizeArray;
        this.array = createArrayNotEmpty(sizeArray, min, max);
    }

    private int[] createArrayNotEmpty(int sizeOfArray,
                                     int minRangeElement, int maxRangeElement) {

        int[] arrayOfInteger = new int[sizeOfArray];

        for (int i = 0; i < arrayOfInteger.length; i ++) {
            arrayOfInteger[i] = (int) (Math.random() * (maxRangeElement - minRangeElement + 1) + minRangeElement);
        }
        return arrayOfInteger;
    }


    public int[] inverseValues(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if(array[i] == 0) {
                array[i] = 1;
            } else array[i] = 0;
        }
        return array;
    }

    public MinMax findMinMax(int[] array) {
        int max= 0 ;
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if(array[i] < min) {
                min = array[i];
            }
            if(array[i] > max) {
                max = array[i];
            }
        }
        return new MinMax(min, max);
    }

    public int[]  doubleValues(int[] array, int ifValueLess)  {
        for (int i = 0; i < array.length; i++) {
            if(array[i] <= ifValueLess) array[i] = array[i]*2;
        }
        return array;
    }

    public boolean checkSum(int [] array) {
        int length = array.length;
        int sumLeft;
        int sumRight;

        if(divideByTwo(length)) {
            sumLeft = sumElement(array,0, length/2);
            sumRight = sumElement(array, length/2, length);
        } else {

            sumLeft = sumElement(array,0, length/2 +1);
            sumRight = sumElement(array, length/2 +1, length);
        }
        System.out.println("Left sum  = " + sumLeft);
        System.out.println("Right sum = " + sumRight);
        return sumLeft == sumRight;
    }

    private boolean divideByTwo(int length) {
        return length % 2 == 0;
    }


    private int sumElement(int[] array, int start, int end) {
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += array[i];
        }
        return sum;
    }


    public int[] rollerCoaster(int[] arrayOfInteger, int step_n) {
        int[] integers = arrayOfInteger;
        if(step_n <0) {
            integers = leftWheel(arrayOfInteger, Math.abs(step_n));
        } else {
            integers = rightWheel(arrayOfInteger, step_n);
        }
        return integers;
    }

    private int[] leftWheel(int[] arrayOfInteger,int step_n) {
        int tmp = 0;
        int i,j =0;
        for (i = 0; i<step_n; i++) {
            tmp = arrayOfInteger[0];
            for (j = 0; j<arrayOfInteger.length-1; j++) {
                arrayOfInteger[j] = arrayOfInteger[j+1];
            }
            arrayOfInteger[arrayOfInteger.length-1] = tmp;
        }

        return arrayOfInteger;
    }

    private int[] rightWheel(int[] arrayOfInteger, int step_n) {
        int tmp = 0;
        int i,j =0;

        for (i = 0; i<step_n; i++) {

            tmp = arrayOfInteger[arrayOfInteger.length-1];
            for (j = arrayOfInteger.length-1; j>0; j--) {
                arrayOfInteger[j] = arrayOfInteger[j-1];
            }
            arrayOfInteger[0] = tmp;
        }
        return arrayOfInteger;
    }


    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public int getSizeArray() {
        return sizeArray;
    }

    public void setSizeArray(int sizeArray) {
        this.sizeArray = sizeArray;
    }

    public class MinMax {
        private int min;
        private int max;

        public MinMax(int min, int max) {
            this.min = min;
            this.max = max;
        }

        public int getMin() {
            return min;
        }

        public int getMax() {
            return max;
        }

        @Override
        public String toString() {
            return "MinMax{" +
                    "min=" + min +
                    ", max=" + max +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "MyArrays{" +
                "array=" + Arrays.toString(array) +
                ", sizeArray=" + sizeArray +
                '}';
    }
}
