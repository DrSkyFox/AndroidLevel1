package ru.gb.gamers;


import ru.gb.game.IBattleField;
import ru.gb.interfaces.PlayersDo;

import java.util.Objects;
import java.util.Scanner;

public class PlayerHuman extends Player implements PlayersDo {

    private IBattleField battleField;

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setMarkPlayer(MarkPlayer markPlayer) {
        this.markPlayer = markPlayer;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public MarkPlayer getMarkPlayer() {
        return this.markPlayer;
    }


    public PlayerHuman(String name, MarkPlayer markPlayer) {
        this.name = name;
        this.markPlayer = markPlayer;
    }

    public PlayerHuman(String name, MarkPlayer markPlayer, IBattleField battleField) {
        this.name = name;
        this.markPlayer = markPlayer;
        this.battleField = battleField;
    }

    public PlayerHuman() {
    }


    public PlayerHuman(IBattleField battleField) {
        this.battleField = battleField;
    }

    @Override
    public void doTurn() {
        int number = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выбирете поле");
        while (true) {
            if(scanner.hasNextInt()) {
                number = scanner.nextInt();
                if(number > 0 && number < 10) {
                    if(battleField.getFieldByNumber(number).getMarkPlayer().equals(MarkPlayer.EMPTY)) {
                        battleField.getFieldByNumber(number).setMarkPlayer(this.markPlayer);
                        break;
                    }
                }
            }
        }
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerHuman that = (PlayerHuman) o;
        return Objects.equals(battleField, that.battleField);
    }

    @Override
    public int hashCode() {
        return Objects.hash(battleField);
    }
}