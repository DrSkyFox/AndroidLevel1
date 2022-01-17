package ru.gb.game;

import ru.gb.gamers.MarkPlayer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class BattleField implements IBattleField {


    private Field[][] field;
    private boolean showFieldNumber = false;
    private Map<Integer, Field> map;


    public Field[][] getField() {
        return field;
    }

    public void setField(Field[][] field) {
        this.field = field;
    }

    public BattleField() {
        createField();
    }

    public BattleField(boolean showFieldNumber) {
        this.showFieldNumber = showFieldNumber;
        createField();
    }

    private void createField() {
        int i;
        field = new Field[][]{
                {new Field(1, MarkPlayer.EMPTY), new Field(2, MarkPlayer.EMPTY), new Field(3, MarkPlayer.EMPTY)},
                {new Field(4, MarkPlayer.EMPTY), new Field(5, MarkPlayer.EMPTY), new Field(6, MarkPlayer.EMPTY)},
                {new Field(7, MarkPlayer.EMPTY), new Field(8, MarkPlayer.EMPTY), new Field(9, MarkPlayer.EMPTY)},
        };

        map = new HashMap();

        for (int f = 0; f < field.length; f++) {
            for (i = 0; i < field.length; i++) {
                map.put(field[f][i].getFieldNumber(), field[f][i]);
            }
        }
    }

    @Override
    public void printField() {
        StringBuilder str;

        for (int i = 0; i < field.length; i++) {
            str = new StringBuilder();
            for (int j = 0; j < field.length; j++) {
                str.append("| ");
                if (showFieldNumber && field[i][j].getMarkPlayer().equals(MarkPlayer.EMPTY)) {
                    str.append(field[i][j].getFieldNumber());
                } else {
                    str.append(field[i][j].getMarkPlayer().getToken());
                }
                str.append(" |");
            }
            System.out.println(str.toString());
            subPrint(str.toString());
        }
    }

    @Override
    public Field getFieldByNumber(Integer fieldNumber) {
        return map.get(fieldNumber);
    }


    @Override
    public int length() {
        return field.length;
    }

    @Override
    public Field getFiledByCoordinate(int x, int y) {
        return field[x][y];
    }

    @Override
    public boolean isWin(MarkPlayer markPlayer) {

        //главная диагональ матрицы
        if (subChecker(0, 0, 1, 1, markPlayer)) return true;
        //обратная диагональ матрицы
        if (subChecker(0, field.length - 1, 1, -1, markPlayer)) return true;

        for (int i = 0; i < field.length; i++) {
            if (subChecker(i, 0, 0, 1, markPlayer)) return true;
            if (subChecker(0, i, 1, 0, markPlayer)) return true;
        }
        return false;
    }

    @Override
    public boolean checkFillField() {
        for (int i = 1; i < map.size()+1; i++) {
            if (
                    map.get(i).getMarkPlayer().equals(MarkPlayer.EMPTY)
            ) {
                return false;
            }
        }
        return true;
    }

    private boolean subChecker(int startXVal, int startYVal, int stepX, int stepY, MarkPlayer markPlayer) {
        for (int i = 0; i < field.length; i++) {
            if (field[startXVal + i * stepX][startYVal + i * stepY].getMarkPlayer() != markPlayer) {
                return false;
            }
        }
        return true;
    }


    private void subPrint(String s) {
        StringBuilder tmp = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            tmp.append('-');
        }
        System.out.println(tmp.toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BattleField that = (BattleField) o;
        return Arrays.equals(field, that.field) && Objects.equals(map, that.map);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(map);
        result = 31 * result + Arrays.hashCode(field);
        return result;
    }


    @Override
    public int getFieldHash() {
        return hashCode();
    }
}