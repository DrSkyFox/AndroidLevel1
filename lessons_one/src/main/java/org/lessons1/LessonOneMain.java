package org.lessons1;

import java.util.Scanner;

public class LessonOneMain {

    private static boolean checkOut = false;

    public static void main(String[] args) {
        IMath m = new Math();
        Scanner scanner = new Scanner(System.in);
        info();
        while (!checkOut) {
            switch (scanner.nextInt()) {
                case 0:
                    checkOut = true;
                    break;
                case 1:
                    System.out.println("Уже есть метод с условно пустым проектом)");
                    break;
                case 2:
                    System.out.println(new Math.Types().toString());
                    break;
                case 3:
                    task3(scanner, m);
                    break;
                case 4:
                    task4(scanner, m);
                    break;
                case 5:
                    m.checkIntegerConsole(task5and6(scanner));
                    break;
                case 6:
                    System.out.println(m.checkIntegerBool(task5and6(scanner)));
                    break;
                case 7:
                    System.out.println("Введите имя");
                    m.hello(scanner.next());
                    break;
                case 8:
                    System.out.println("Введите год");
                    m.taskEight(scanner.nextInt());
                    break;
            }
            System.out.println("\n");
            info();
        }
    }

    private static void task3(Scanner scanner, IMath m) {
        System.out.println("Введите число а");
        var a = scanner.nextFloat();
        System.out.println("Введите число b");
        var b = scanner.nextFloat();
        System.out.println("Введите число c");
        var c = scanner.nextFloat();
        System.out.println("Введите число d");
        var d = scanner.nextFloat();
        var res = m.mathExpressionCalc(a, b, c, d);
        System.out.println("результат: " + res);
    }

    private static void task4(Scanner scanner, IMath m) {
        System.out.println("Введите число а");
        var a = scanner.nextInt();
        System.out.println("Введите число b");
        var b = scanner.nextInt();
        System.out.println(m.inRange(a, b));
    }

    private static int task5and6(Scanner scanner) {
        System.out.println("Введите число");
        var a = scanner.nextInt();
        return a;
    }


    private static void info() {
        System.out.println("""
                Выбирете задачу. 0. Выход \s
                1. Создать пустой проект в IntelliJ IDEA и прописать метод main().
                2.  Создать переменные всех пройденных типов данных и инициализировать их значения.
                3. Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,\s
                где a, b, c, d – аргументы этого метода, имеющие тип float.
                4. Написать метод, принимающий на вход два целых числа и проверяющий, что их сумма лежит в пределах от 10 до 20 (включительно), если да – вернуть true, в противном случае – false.
                5 .Написать метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль, положительное ли число передали или отрицательное. Замечание: ноль считаем положительным числом.
                6. Написать метод, которому в качестве параметра передается целое число. Метод должен вернуть true, если число отрицательное, и вернуть false если положительное.
                7. Написать метод, которому в качестве параметра передается строка, обозначающая имя. Метод должен вывести в консоль сообщение «Привет, указанное_имя!».
                8. Написать метод, который определяет, является ли год високосным, и выводит сообщение в консоль. Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
                """);
    }

}
