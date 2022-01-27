package ru.gb;

import ru.gb.blockage.CrossRoad;
import ru.gb.blockage.SwimmingPool;
import ru.gb.interfaces.OverComable;
import ru.gb.interfaces.Particible;
import ru.gb.participants.Cat;
import ru.gb.participants.Dog;
import ru.gb.utils.UtilTote;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Tote {
    private int totalWin = 0;
    private int bet = 0;
    private int countOfParticipants = 0;
    private Particible choose = null;
    private Map<Integer, Particible> particibleList;
    private Map<Integer, OverComable> overComables;

    private Scanner scanner;

    public Tote(Scanner scanner) {
        this.scanner = scanner;
    }


    public void runTote() {
        Particible winner;

        System.out.println("Настало время тотализатора! \n Наши участники это кошки и собаки. Полоса препятсвия - беговая дорожка и бассейн");
        while (true) {
            System.out.println("Введите кол-во участников !");

            countOfParticipants = checkInputValue();

            System.out.println("Всего устастников:  " + countOfParticipants);

            particibleList = getAllParticipants(countOfParticipants);

            printListParticipants();

            System.out.println("Кто наберет больше всего очков ? Введите номер участника");
            choose = particibleList.get(checkInputValue());
            System.out.println("Сколько вы готовы поставить ?");
            bet = checkInputValue();

            System.out.println("Вы выбрали участника под номером: " + choose);

            System.out.println("Генерируем полосу препятсвия !");
            overComables = getAllOverComable(5, 20);
            System.out.println("Наша полоса препятсвий!");
            printListOverComeble();

            System.out.println("---------------------------------------------");
            System.out.println("Начинаем забег !");
            runningAllStages();
            System.out.println("Забег закончен");

            System.out.println("---------------------------------------------");

            winner = getMaxScore();
            System.out.println("Победитель забега: " + winner + "co счетом " + winner.getScore());

            if (winner.equals(choose)) {
                System.out.println("Вы выйграли!");
                totalWin += bet;
            } else {
                System.out.println("Вы проиграли!");
                totalWin -= bet;
            }
            System.out.println("Ваш счет: " + totalWin);

            System.out.println("Сделаем еще ставочку ?");
            if(!checkInput()) {
                break;
            }
        }
    }


    private boolean checkInput() {
        System.out.println("yes - 1 / no - 2 ? Input num");
        while (true) {
            if(scanner.hasNextInt()) {
                if(scanner.nextInt() == 1) {
                    return true;
                } else return false;
            }
        }
    }

    private void runningAllStages() {
        int i, j;
        for (i = 0; i < particibleList.size(); i++) {
            for (j = 0; j < overComables.size(); j++) {
                particibleList.get(i+1).overcome(overComables.get(j));
            }
        }
    }

    private Particible getMaxScore() {
        int score = 0;
        Particible winner = null;
        for (int i = 0; i < particibleList.size(); i++) {
            if(score < particibleList.get(i+1).getScore()) {
                score = particibleList.get(i+1).getScore();
                winner = particibleList.get(i+1);
            }
        }
        return winner;
    }

    private int checkInputValue() {
        while (true) {
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            }
            System.out.println("Повторите попытку ввода числа !");
        }
    }

    private void printListParticipants() {
        for (int i = 0; i < countOfParticipants; i++) {
            System.out.println("Участник: " + particibleList.get(i+1) + " под номером: " + i);
        }
    }

    private void printListOverComeble() {
        for (int i = 0; i < overComables.size(); i++) {
            System.out.println("Полоса препятсвий: " + overComables.get(i));
        }
    }


    private Map<Integer, Particible> getAllParticipants(int countOfParticipants) {
        Map<Integer, Particible> map = new HashMap();
        Random random = new Random();
        for (int i = 0; i < countOfParticipants; i++) {
            if (random.nextInt(100) < 50) {
                map.put(i+1, new Cat());
            } else {
                map.put(i+1, new Dog());
            }
        }
        return map;
    }


    private Map<Integer, OverComable> getAllOverComable(int min, int max) {
        var count = UtilTote.getRandomNumberUsingNextInt(min, max);
        Map<Integer, OverComable> map = new HashMap<>();
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            if (random.nextInt(100) < 50) {
                map.put(i, new CrossRoad());
            } else {
                map.put(i, new SwimmingPool());
            }
        }
        return map;
    }
}
