package ru.gb.game;

import ru.gb.gamers.MarkPlayer;

public interface IBattleField {
    boolean isWin(MarkPlayer markPlayer);
    Field getFieldByNumber(Integer fieldNumber);
    void printField();
    Field getFiledByCoordinate(int x, int y);
    int length();
    int getFieldHash();
    boolean checkFillField();
}
