package ru.vsu.cs.util.steblev_d_v.exceptions;

public class BoardReaderException extends Exception{
    public BoardReaderException(String errorMessage, int lineInd) {
        super("Ошибка чтения строки: " + lineInd + ". " + errorMessage);
    }

}
