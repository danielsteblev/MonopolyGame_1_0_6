package ru.vsu.cs.util.steblev_d_v;

import ru.vsu.cs.util.steblev_d_v.cards.Card;

import java.util.*;

import static java.lang.Math.round;


public class Board implements GraphicsManagerInterface {
    private List<Card> board = new ArrayList<>();
    private List<String> graphicsBoard = new ArrayList<>();
    public static List<Integer> lastIndexes = new ArrayList<>();
    public static List<String> deletedELements = new ArrayList<>();

    public List<String> generateGraphicsBoard(List<Card> board) {
        List<String> graphicsBoard = new ArrayList<>();
        for (int i = 0; i < board.size(); i++) {
            graphicsBoard.add(board.get(i).getName());
        }
        return graphicsBoard;
    }

    public void render() {
        // Рендер верхней строки
        for (int k = 0; k < board.size() / 4 + 1; k++) {
            if (k == board.size() / 4) {
                TextArea textArea = new TextArea(board.get(board.size() / 4).getName(), BLACK_BOLD, board.get(k).getColor(),
                        "row");
                textArea.sizeNormalize(board);
                textArea.render();
                break;
            }
            TextArea textArea = new TextArea(board.get(k).getName(), BLACK_BOLD, board.get(k).getColor(), "row");
            textArea.sizeNormalize(board);
            textArea.render();
        }
        System.out.println();

        // Рендер центра
        for (int k = board.size() / 4 + 1, j = board.size() - 1; k < board.size() / 2 && j > board.size() / 2 + 0.2 * board.size(); k++, j--) {
            TextArea textArea = new TextArea(board.get(j).getName(), BLACK_BOLD, board.get(j).getColor(), "col");
            TextArea textArea2 = new TextArea(board.get(k).getName(), BLACK_BOLD, board.get(k).getColor(), "col");
            textArea.sizeNormalize(board);
            textArea2.sizeNormalize(board);
            textArea.renderCentralLines(textArea, textArea2, board);
        }

        // Рендер нижней строки
        for (int g = board.size() - board.size() / 4; g >= board.size() / 2; g--) {
            TextArea textArea = new TextArea(board.get(g).getName(), BLACK_BOLD, board.get(g).getColor(), "row");
            textArea.sizeNormalize(board);
            textArea.render();
        }
    }


    public void writePlayersMapping(List<Player> players) {
        graphicsBoard = generateGraphicsBoard(board);
        if (GameSession.numberOfMove == 1) { // Проверка на 1 ход
            for (int i = 0; i < players.size(); i++) {
                lastIndexes.add(0);
                deletedELements.add(String.valueOf(graphicsBoard.get(players.get(i).getCurrCardIndex())));
            }
        }
        for (int i = 0; i < players.size(); i++) {
            /*
            Возвращаем удалённый элемент на место, до этого записав его индекс и сам элемент в список.
             */
            graphicsBoard.set(lastIndexes.get(i), deletedELements.get(i));
            lastIndexes.set(i, players.get(i).getCurrCardIndex()); // Запоминаем новый индекс удалённого элемента
            deletedELements.set(i, graphicsBoard.get(players.get(i).getCurrCardIndex())); // Запоминаем новый удалённый элемент
            graphicsBoard.set(players.get(i).getCurrCardIndex(), CYAN_BACKGROUND_BRIGHT + BLACK_BOLD + players.get(i).getName() + ANSI_RESET);
            /*
            Запомнили всё, что нужно и только теперь можем поставить маркер игрока на поле, где он стоит.
             */
        }
    }

    public List<Card> getBoard() {
        return board;
    }

    @Override
    public String toString() {
        return "board=" + board;
    }
}






