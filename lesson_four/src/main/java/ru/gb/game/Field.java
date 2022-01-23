package ru.gb.game;

import ru.gb.gamers.MarkPlayer;

import java.util.Objects;

public class Field {
    private Integer fieldNumber;
    private MarkPlayer markPlayer;

    public Field(Integer fieldNumber, MarkPlayer markPlayer) {
        this.fieldNumber = fieldNumber;
        this.markPlayer = markPlayer;
    }


    public Integer getFieldNumber() {
        return fieldNumber;
    }

    public void setFieldNumber(Integer fieldNumber) {
        this.fieldNumber = fieldNumber;
    }

    public MarkPlayer getMarkPlayer() {
        return markPlayer;
    }

    public void setMarkPlayer(MarkPlayer markPlayer) {
        this.markPlayer = markPlayer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Field field = (Field) o;
        return Objects.equals(fieldNumber, field.fieldNumber) && markPlayer == field.markPlayer;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fieldNumber, markPlayer);
    }
}
