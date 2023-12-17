package ru.vsu.cs.util.steblev_d_v;

import ru.vsu.cs.util.steblev_d_v.graphics.Board;
import ru.vsu.cs.util.steblev_d_v.boardReader.BoardReader;
import ru.vsu.cs.util.steblev_d_v.boardReader.BoardReaderException;

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
        Board board = BoardReader.read(fileContent);
        GameSession game = new GameSession(board);
        game.startGame();


    }
}
