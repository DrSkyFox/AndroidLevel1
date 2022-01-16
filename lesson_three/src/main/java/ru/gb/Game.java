package ru.gb;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Logger;

public class Game {

    private final static Logger logger = Logger.getLogger(Game.class.getName());

    private static HashMap<Integer, String> dictionary;
    private static int numWord;
    private static int tryingCount = 0;
    private static int maxCapacityWord = 0;
    private static boolean autoCapacityEnabled = true;


    private static class Answer {
        public String Ans;
        public int guessed_letters;
    }


    public static void setAutoCapacityEnabled(boolean autoCapacityEnabled) {
        Game.autoCapacityEnabled = autoCapacityEnabled;
        System.out.println("autoCapacityEnabled: " +  autoCapacityEnabled);
    }

    public static void setMaxCapacityWord(int maxCapacityWord) {
        Game.maxCapacityWord = maxCapacityWord;
        autoCapacityEnabled = false;
    }

    public static Logger getLogger() {
        return logger;
    }

    public Game(String [] eatable) {
        if(eatable == null){
            System.out.println("Нету съедобностей");
        }

        dictionary = new HashMap<>();
        for (int i = 0; i < eatable.length; i++) {
            dictionary.put(i, eatable[i]);
            if (autoCapacityEnabled) autoSettingCappacity(eatable[i]);
        }
        numWord = new Random().nextInt(eatable.length-1);
        System.out.println("Скажи мне, что же я хочу съесть ?");
    }

    private void autoSettingCappacity(String tmp) {
        if(maxCapacityWord < tmp.length()) {
            maxCapacityWord = tmp.length();
        }
    }

    public void startGame() {
        boolean game_running = true;
        Answer answer = new Answer();
        answer.guessed_letters = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Что же я хочу съесть ?");
        answer.Ans = scanner.nextLine();
        while (game_running) {
            tryingCount++;
            if(dictionary.get(numWord).equals(answer.Ans)) {
                game_running = false;
                System.out.printf("Ты угадал c %d!%n Я хочу сьесть %s!",tryingCount, dictionary.get(numWord));
            } else {
                checkWord(answer);

                System.out.printf("Ты угадал %d букв%s%nСовпало: %s%n",
                        answer.guessed_letters,
                        changeEnd(answer.guessed_letters),
                        answer.Ans);

                System.out.println("Попытайся снова! Текущая попытка № " + tryingCount);
                System.out.println("Если хочешь сдаться, то набери 'Пощади!'");
                answer.Ans = scanner.nextLine().toLowerCase();
            }

            if(answer.Ans.equals("Пощади") && game_running ==true) {
                game_running = false;
                System.out.println("Я ожидал лучшего.... XD");
            }
        }
    }


    private String changeEnd(int counted) {
        if(counted == 1) {
            return "у";
        } else if(counted >1 && counted < 5) {
            return "ы";
        } else return "";
    }


    private void checkWord(Answer answer) {
        StringBuilder builder = new StringBuilder(maxCapacityWord);
        answer.guessed_letters = 0;

        logger.info("Ans: " + answer.Ans + "; Word: " + dictionary.get(numWord));
        logger.info("numWord:" + numWord);

        for (int i = 0; i < maxCapacityWord; i++) {
            if( (i < (dictionary.get(numWord).length()-1)) && (i < (answer.Ans.length()))) {
                if(answer.Ans.charAt(i) == dictionary.get(numWord).charAt(i)) {
                    builder.append(answer.Ans.charAt(i));
                    answer.guessed_letters++;
                } else {
                    builder.append("#");
                }
            } else builder.append('#');
        }
        answer.Ans = builder.toString();
    }







}