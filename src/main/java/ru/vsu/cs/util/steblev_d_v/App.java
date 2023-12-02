package ru.vsu.cs.util.steblev_d_v;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.lang.Math.round;

public class App
{
    public static void main( String[] args ) throws IOException, BoardReaderException {

        Path fileName = Path.of(
                "C:\\JavaUniversity\\MonopolyGame\\src\\main\\java\\ru\\vsu\\cs\\util\\steblev_d_v\\boards\\board.txt");
        String fileContent = Files.readString(fileName);
        System.out.println("Loading board ...");

        Board board = BoardReader.read(fileContent);
        System.out.println(board.toString());


        GameSession gameLogic = new GameSession(board);
        gameLogic.startGame();


    }
}
