package ru.gb.interfaces;

import ru.gb.gamers.MarkPlayer;

public interface PlayersDo {
    void doTurn();
    void setName(String name);
    void setMarkPlayer(MarkPlayer markPlayer);
    String getName();
    MarkPlayer getMarkPlayer();
}
