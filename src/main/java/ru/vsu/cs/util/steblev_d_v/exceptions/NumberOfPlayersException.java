package ru.vsu.cs.util.steblev_d_v.exceptions;

public class NumberOfPlayersException extends IndexOutOfBoundsException{

    public NumberOfPlayersException(int countPlayers) {
        super("Количество игроков должно быть в диапазоне от 2 до 4! Ваше количество: " + countPlayers);
    }
}
