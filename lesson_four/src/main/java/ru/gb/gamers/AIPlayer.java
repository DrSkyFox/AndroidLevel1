package ru.gb.gamers;


import ru.gb.game.IBattleField;
import ru.gb.interfaces.PlayersDo;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;


public class AIPlayer extends Player implements PlayersDo {

    private IBattleField battleField;
    private Boolean useHash = true;

    private final CoordVal coordVal = new CoordVal(0,0);




    public IBattleField getBattleField() {
        return battleField;
    }

    public void setBattleField(IBattleField battleField) {
        this.battleField = battleField;
    }

    public Boolean getUseHash() {
        return useHash;
    }

    public void setUseHash(Boolean useHash) {
        this.useHash = useHash;
    }

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



    public AIPlayer(String name, MarkPlayer markPlayer, IBattleField battleField) {
        System.out.println(battleField.getFieldHash());
        this.name = name;
        this.markPlayer = markPlayer;
        this.battleField = battleField;
    }

    public AIPlayer(IBattleField battleField) {
        System.out.println(battleField.getFieldHash());
        this.battleField = battleField;
    }

    public AIPlayer() {
    }

    public AIPlayer(MarkPlayer markPlayer) {
        this.markPlayer = markPlayer;
    }



    @Override
    public void doTurn() {
        boolean checkWin = false;
        if(useHash) {
            checkWin = playerCanWinHash();
        } else {
            checkWin = playerCanWin();
        }

        if (!checkWin) {
            markTheBox();
        } else {
            if (useHash) {
                battleField.getFieldByNumber(coordVal.xVal).setMarkPlayer(this.markPlayer);
            } else {
                battleField.getFiledByCoordinate(coordVal.xVal,coordVal.yVal).setMarkPlayer(this.markPlayer);
            }
        }
    }

    public int getRandomNumberUsingNextInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

    private void markTheBox() {
        Integer num;
        while (true) {
            num = getRandomNumberUsingNextInt(1,9);

            if(battleField.getFieldByNumber(num).getMarkPlayer().equals(MarkPlayer.EMPTY)) {
                battleField.getFieldByNumber(num).setMarkPlayer(this.markPlayer);
                break;
            }
        }
    }

    private boolean playerCanWin() {
        boolean status = false;
        boolean check = false;
        for (int i = 0; i < battleField.length(); i++) {
            for (int j = 0; j < battleField.length(); j++) {
                if(battleField.getFiledByCoordinate(i,j).getMarkPlayer().equals(MarkPlayer.EMPTY)) {
                    battleField.getFiledByCoordinate(i,j).setMarkPlayer(getEnemyMark());
                    check =battleField.isWin(getEnemyMark());
                    if(check) {
                        coordVal.xVal = i;
                        coordVal.yVal = j;
                        status =true;
                    }
                    battleField.getFiledByCoordinate(i,j).setMarkPlayer(MarkPlayer.EMPTY);

                }
            }
        }
        return status;
    }


    private boolean playerCanWinHash() {
        boolean status = false;
        boolean check = false;

        var sizeFields = battleField.length()* battleField.length();
        for (int i = 1; i < sizeFields; i++) {
            if(battleField.getFieldByNumber(i).getMarkPlayer().equals(MarkPlayer.EMPTY)) {
                battleField.getFieldByNumber(i).setMarkPlayer(getEnemyMark());
                check = battleField.isWin(getEnemyMark());
                if (check) {
                    coordVal.xVal = i;
                    status = true;
                }
                battleField.getFieldByNumber(i).setMarkPlayer(MarkPlayer.EMPTY);
            }
        }
        return status;
    }



    public MarkPlayer getEnemyMark() {
        var params = Arrays.stream(MarkPlayer.values()).toList();
        for (MarkPlayer markPlayer: params
             ) {
            if(!markPlayer.equals(MarkPlayer.EMPTY)) {
                if(!markPlayer.equals(this.markPlayer)) {
                    return markPlayer;
                }
            }
        }
        return null;
    }

    private class CoordVal {
        public int xVal;
        public int yVal;

        public CoordVal(int xVal, int yVal) {
            this.xVal = xVal;
            this.yVal = yVal;
        }

        public CoordVal(int xVal) {
            this.xVal = xVal;
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AIPlayer aiPlayer = (AIPlayer) o;
        return Objects.equals(battleField, aiPlayer.battleField) && Objects.equals(useHash, aiPlayer.useHash) && Objects.equals(coordVal, aiPlayer.coordVal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(battleField, useHash, coordVal);
    }

}