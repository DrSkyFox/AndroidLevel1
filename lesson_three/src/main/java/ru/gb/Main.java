package ru.gb;

import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;


public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] words = {
                "apple", "orange", "lemon", "banana",
                "apricot", "avocado", "broccoli",
                "carrot", "cherry", "garlic",
                "grape", "melon", "leak",
                "kiwi", "mango", "mushroom",
                "nut", "olive", "pea",
                "peanut", "pear", "pepper",
                "pineapple", "pumpkin", "potato"
        };

        System.out.println("Угайд число ? Играем 1, нет 0");

        if(scanner.next().equals("1")) {
            GameOneToNine gameOneToNine = new GameOneToNine(scanner);
            gameOneToNine.start();
        }


        System.out.println("Что я хочу съесть ? Играем 1, нет 0");
        if(scanner.next().equals("1")) {

            System.out.println(Arrays.asList(words));

            Game.setMaxCapacityWord(15);
            Game game = new Game(words);

            LogManager.getLogManager().getLogger(Logger.GLOBAL_LOGGER_NAME).setLevel(Level.OFF);
            game.startGame();
        }



    }
}
