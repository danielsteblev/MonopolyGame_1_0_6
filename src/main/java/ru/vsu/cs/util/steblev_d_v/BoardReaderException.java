package ru.vsu.cs.util.steblev_d_v;

public class BoardReaderException extends Exception{
    public BoardReaderException(String errorMessage, int lineInd) {
        super("Error parsing board file on line: " + lineInd + ". " + errorMessage);
    }

}
