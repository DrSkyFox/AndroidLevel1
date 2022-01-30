package ru.gb;

import ru.gb.interfaces.Conquerable;
import ru.gb.interfaces.Preventable;
import ru.gb.model.*;

import java.util.*;
import java.util.stream.Collectors;

public class Tote implements Runnable {


    private Map<Integer, Conquerable> conquerables;
    private Map<Integer, Preventable> preventables;

    private static final Integer DEFAULT_COUNT_CONQUER = 10;
    private static final Integer DEFAULT_COUNT_PREVENT = 20;

    public Tote(Scanner scanner) {
        initDefault(scanner);
    }

    public Tote() {
        initDefault();
    }

    private void initDefault(Scanner scanner) {
        System.out.println("Подготовка к забегу");
        System.out.println("Введите кол-во участников");
        preConquerable(scannerCheck(scanner));
        printArray(conquerables);
        System.out.println("Введите кол-во препятсвий");
        prePreventable(scannerCheck(scanner));
        printArray(preventables);
    }

    private Integer scannerCheck(Scanner scanner) {
        while (true) {
            if(scanner.hasNextInt()) {
                break;
            }
        }
        return scanner.nextInt();
    }

    private void initDefault() {
        System.out.println("Подготовка к забегу");
        preConquerable(DEFAULT_COUNT_CONQUER);
        printArray(conquerables);
        prePreventable(DEFAULT_COUNT_PREVENT);
        printArray(preventables);
    }

    @Override
    public void run() {
        System.out.println("Старт забега");
        conquerRun();
        checkWinnerAndPrintState();
    }

    private void checkWinnerAndPrintState() {
        List<Conquerable> conquerablesLocal = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < conquerables.size(); i++) {
            conquerablesLocal.add(conquerables.get(i));
        }
        conquerablesLocal = conquerablesLocal.stream().sorted(Comparator.comparingInt(Conquerable::getCompletedStage).reversed()).collect(Collectors.toList());

        for (int i = 0; i < conquerablesLocal.size(); i++) {
            System.out.println(builder.append("№").append(i+1)
                    .append(" участник -").append(conquerablesLocal.get(i)));
            builder.setLength(0);
        }

    }


    private void conquerRun() {
        int j = 0;
        int counterStopped =0;
        for (int i = 0; i < preventables.size(); i++) {
            System.out.println("---------------------------------------------------------");
            System.out.println("Препятсвие " + i + " " + preventables.get(i));
            System.out.println("Остановившихся: " + counterStopped);
            if(counterStopped == conquerables.size()) {
                if(i == preventables.size() -1) {
                    System.out.println("Никто не добежал до финиша. Соревнование остановлено");
                } else {
                    System.out.println("Соревнование завершилось");
                }
                return;
            }
            for (j = 0; j < conquerables.size(); j++) {
                if (!conquerables.get(j).hasStopped()) {
                    System.out.println("Участник " + conquerables.get(j) + " выполняет препятсвие");
                    conquerables.get(j).justDoIt(preventables.get(i));
                    if(conquerables.get(j).hasStopped()) {
                        counterStopped++;
                    }
                }
            }
        }
    }

    private void preConquerable(int count) {
        System.out.println("Всего участников: " + count);
        Random random = new Random();
        conquerables = new HashMap();
        for (int i = 0; i < count; i++) {
            conquerables.put(i, getConquerableType(random.nextInt(90)));
        }
    }

    private void prePreventable(int count) {
        System.out.println("Всего препятсвий: " + count);
        Random random = new Random();
        preventables = new HashMap();
        for (int i = 0; i < count; i++) {
            preventables.put(i, getPreventableType(random.nextInt(100)));
        }
    }

    private Conquerable getConquerableType(int type) {
        Conquerable conquerable = null;
        if(60 < type ) {
            return new Robot();
        } else if(30 < type && type <= 60) {
            return new Human();
        } else return new Cat();
    }

    private Preventable getPreventableType(int type) {
        System.out.println("type: " + type);
        Preventable preventable = null;
        if(type > 50) {
            return new CrossWay();
        }
        return new Wall();
    }

    private void printArray(Map<?, ?> map) {
        for (int i = 0; i < map.size(); i++) {
            System.out.println(map.get(i));
        }
    }


}
