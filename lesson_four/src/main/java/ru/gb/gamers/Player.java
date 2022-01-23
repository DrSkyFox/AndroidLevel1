package ru.gb.gamers;

import java.util.Objects;

public abstract class Player {

    protected MarkPlayer markPlayer;
    protected String name;

    public MarkPlayer getMarkPlayer() {
        return markPlayer;
    }

    public void setMarkPlayer(MarkPlayer markPlayer) {
        this.markPlayer = markPlayer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return markPlayer == player.markPlayer && Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(markPlayer, name);
    }
}