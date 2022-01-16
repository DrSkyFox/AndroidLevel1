package ru.gb;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Logger;

public class GameOneToNine {

    private final static Logger logger = Logger.getLogger(GameOneToNine.class.getName());

    private Integer number;
    private Scanner scanner;
    private NumberStatus status = NumberStatus.CONTINUE;
    private static String defaultStartMsg = "Ваше значение ";
    private static String endFinalMsgWrong = " загаданного числа";
    private static String endFinalMsgWin = " загаднному числу";


    public GameOneToNine(Scanner scanner) {
        newGame();
        this.scanner = scanner;
    }


    public void start(){
        System.out.println("Угадай число от 0 до 9");
        while (status != NumberStatus.EXIT) {
            compare(scanner.nextInt());
            continueGame(scanner);
        }
    }

    private void newGame() {
        this.number = new Random().nextInt(9);
    }

    private void compare(Integer num) {
        if(number == num) {
            System.out.println(defaultStartMsg + num + " " + NumberStatus.EQUALS.getTitle() + endFinalMsgWin);
            this.status = NumberStatus.EQUALS;
        } else if (number < num) {
            System.out.println(defaultStartMsg + num + " " + NumberStatus.HIGH.getTitle() + endFinalMsgWrong);
        } else {
            System.out.println(defaultStartMsg + num + " " + NumberStatus.LESS.getTitle() + endFinalMsgWrong);
        }
    }

    private void continueGame(Scanner scanner) {
        int num = 9;

        System.out.println("Повторить игру еще раз?");
        while (num >= 2 || num < 0) {
            System.out.println("1 – да / 0 – нет»(1 – повторить, 0 – нет");
            num = scanner.nextInt();
        }

        if(num == 0) {
            System.out.println("Выход из игры");
            status = NumberStatus.EXIT;
        } else {
            System.out.println(NumberStatus.CONTINUE.getTitle());
            if(status == NumberStatus.EQUALS) {
                System.out.println("Начинаем новую игру. Угадай число !");
                newGame();
                status = NumberStatus.CONTINUE;
            }
            status =  NumberStatus.CONTINUE;
        }
    }



    enum NumberStatus {
        LESS ("меньше"),
        HIGH ("больше"),
        EQUALS("равно"),
        CONTINUE("Продолжаем"),
        EXIT("Выход");

        private String title;

        NumberStatus(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }


    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameOneToNine that = (GameOneToNine) o;
        return Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
