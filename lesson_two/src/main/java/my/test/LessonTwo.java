package my.test;

public class LessonTwo {
    public static void main(String[] args) {
        // Task1
        System.out.println("Task 1");
        System.out.println("--------------------------------------------------");
        MyArrays array = new MyArrays(10, 0, 1);
        System.out.println(array);
        array.inverseValues(array.getArray());
        System.out.println(array);
        System.out.println("--------------------------------------------------");
        // Task2

        System.out.println("Task 2");
        System.out.println("--------------------------------------------------");
        int [] arrayTwo = arrayCreate();
        for (int i = 0; i < arrayTwo.length; i++) {
            System.out.print(arrayTwo[i] + " ");
        }
        System.out.println("--------------------------------------------------");
        // Task3

        System.out.println("Task 3");
        System.out.println("--------------------------------------------------");
        MyArrays arrayThree = new MyArrays(20, 0, 10);
        System.out.println(arrayThree);
        arrayThree.doubleValues(arrayThree.getArray(),6);
        System.out.println(arrayThree);
        System.out.println("--------------------------------------------------");
        // Task4
        System.out.println("Task 4");
        System.out.println("--------------------------------------------------");
        printMatrix(5,5);
        System.out.println("--------------------------------------------------");
        // Task5

        System.out.println("Task 5");
        System.out.println("--------------------------------------------------");
        array = new MyArrays(10, 0, 100);
        System.out.println(array);
        MyArrays.MinMax minMax = array.findMinMax(array.getArray());
        System.out.println(minMax.toString());
        System.out.println("--------------------------------------------------");

        System.out.println("Task 6");
        System.out.println("--------------------------------------------------");
        array = new MyArrays(10, 0, 10);
        System.out.println(array);
        System.out.println(array.checkSum(array.getArray()));
        array.setArray(new int[] {1,1 ,1,1});
        System.out.println(array);
        System.out.println(array.checkSum(array.getArray()));
        System.out.println("--------------------------------------------------");

        System.out.println("Task 7");
        System.out.println("--------------------------------------------------");
        array = new MyArrays(10, 0 , 10);
        System.out.println(array);
        array.rollerCoaster(array.getArray(), 3);
        System.out.println(array);
        array.rollerCoaster(array.getArray(), -3);
        System.out.println(array);

        array.rollerCoaster(array.getArray(), -9);
        System.out.println(array);

        array.rollerCoaster(array.getArray(), 7);
        System.out.println(array);

        System.out.println("--------------------------------------------------");


    }

    private static int[] arrayCreate() {
        int [] array = new int[] {0, 3, 6, 9, 12, 15, 18, 21};
        return array;
    }

    private static int[][] createMatrix(int rows, int columns)  {
        int [][] matrix = new int[rows][columns];
        int j = 0;
        for (int i = 0; i < rows; i++) {
            for (j = 0; j < columns; j++) {
                if(i==j) {
                    matrix[i][j] = 1;
                } else matrix[i][j] =0;
            }
        }
        return matrix;
    }

    private static void printMatrix(int rows, int columns) {
        int [][] matrix = createMatrix(rows, columns);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }


}
