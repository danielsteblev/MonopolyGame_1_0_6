package ru.vsu.cs.util.steblev_d_v;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException, BoardReaderException {
//     GameLogic gameLogic = new GameLogic();
//     gameLogic.startGame();

        Path fileName = Path.of(
                "C:\\JavaUniversity\\MonopolyGame\\src\\main\\java\\ru\\vsu\\cs\\util\\steblev_d_v\\boards\\board.txt");
        String fileContent = Files.readString(fileName);
        System.out.println("Loading board ...");

        Board board = BoardReader.read(fileContent);
        System.out.println(board.toString());
        System.out.println(board.getBoard().get(1).getLocationIndex());
        System.out.println(board.getBoard().size());




    }
}
