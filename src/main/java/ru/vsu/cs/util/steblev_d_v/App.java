package ru.vsu.cs.util.steblev_d_v;

import ru.vsu.cs.util.steblev_d_v.graphics.Board;
import ru.vsu.cs.util.steblev_d_v.boardReader.BoardReader;
import ru.vsu.cs.util.steblev_d_v.exceptions.BoardReaderException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class App {
    /**
     * Консольная игра Монополия
     * @author Danila Steblev
     */
    public static void main(String[] args) throws IOException, BoardReaderException {
        Path fileName = Path.of("C:\\Users\\HUAWEI\\MonopolyGame_1_0_4\\boards\\board.txt");
        Board board;
        try {
            String fileContent = Files.readString(fileName);
             board = BoardReader.read(fileContent);
        } catch (Exception e) {
            throw new FileNotFoundException("Указан неверный путь к игровому полю!");
        }
        GameSession game = new GameSession(board);
        game.startGame();
    }
}
