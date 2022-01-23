package ru.gb.gamers;

public enum MarkPlayer {
    EMPTY("-"),
    X("X"),
    O("O");

    private String token;

    MarkPlayer(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

}
