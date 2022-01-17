package ru.gb.game;


import ru.gb.gamers.AIPlayer;
import ru.gb.gamers.MarkPlayer;
import ru.gb.gamers.PlayerHuman;
import ru.gb.interfaces.PlayersDo;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class GameTikTok {

    private IBattleField battleField;
    private Map<Integer, PlayersDo> players;
    private Scanner scanner = new Scanner(System.in);
    private int turn = 1;


    public GameTikTok() {

        this.battleField = new BattleField(true);
        PlayersDo playerOne;
        PlayersDo playerTwo;


        players = new HashMap<>();

        System.out.println("Включить настройки по умолчаннию ? y/n");

        if (checkInput("y", "n")) {
            defaultSettings();
            return;
        }

        System.out.println("Сыграть против AI");
        if (checkInput("y", "n")) {
            playerOne = createNewPlayer(new AIPlayer(battleField));
        } else {
            playerOne = createNewPlayer(new PlayerHuman(battleField));
        }

        System.out.println("Второй игрок");
        playerTwo = createNewPlayer(new PlayerHuman());

        System.out.println("Определяем кто первый ходит");

        if (getNumber() == 1) {
            players.put(1, playerOne);
            players.put(2, playerTwo);
        } else {
            players.put(2, playerOne);
            players.put(1, playerTwo);
        }


    }

    private void defaultSettings() {
        System.out.println("Выбраны настройки по умолчанию");
        System.out.println("hash map is " + battleField.getFieldHash());
        players.put(1, new PlayerHuman("Player 1", MarkPlayer.X, battleField));
        System.out.println(players.get(1).toString());
        System.out.println("hash map is " + battleField.getFieldHash());
        players.put(2, new AIPlayer("Player 2", MarkPlayer.O, battleField));
        System.out.println(players.get(2).toString());
    }

    private int getNumber() {
        if (new Random(100).nextInt() < 50) {
            return 1;
        } else return 2;
    }


    private <T extends PlayersDo> PlayersDo createNewPlayer(T player) {
        String name;
        MarkPlayer markPlayer;

        System.out.println("Введите имя игрока или пропустите");
        name = scanner.next();
        System.out.println("Выбирете марку X/O для AI");
        if (checkInput("X", "O")) {
            markPlayer = MarkPlayer.X;
        } else markPlayer = MarkPlayer.O;
        player.setName(name);
        player.setMarkPlayer(markPlayer);
        return player;
    }


    private boolean checkInput(String s1, String s2) {
        String input = "";
        while (true) {
            input = scanner.next();
            if (input.equals(s1)) {
                return true;
            } else if (input.equals(s2)) {
                return false;
            } else {
                System.out.println("Введите " + s1 + " или " + s2);
            }
        }
    }




    public void gameStart() {
        System.out.println("Добро пожаловать в крестики - нолики");
        battleField.printField();

        while (true) {

            System.out.println("Ходит первый игрок: " + players.get(1).getName());

            players.get(1).doTurn();
            battleField.printField();


            if (battleField.isWin(players.get(1).getMarkPlayer())) {
                System.out.println("Игрок" + players.get(1).getName() + " победил !");
                break;
            }

            turn++;
            System.out.println("Turn : " + turn);
            if(turn >= battleField.length()) {
                if(battleField.checkFillField()) {
                    System.out.println("Ничья");
                    break;
                }
            }

            System.out.println("Ходит второй игрок" + players.get(2).getName());
            players.get(2).doTurn();
            battleField.printField();

            if (battleField.isWin(players.get(2).getMarkPlayer())) {
                System.out.println("Игрок " + players.get(2).getMarkPlayer() + " победил !");
                break;
            }
            turn++;
            System.out.println("Turn : " + turn);
            if(turn >= battleField.length()) {
                if(battleField.checkFillField()) {
                    System.out.println("Ничья");
                    break;
                }
            }
        }

    }




}