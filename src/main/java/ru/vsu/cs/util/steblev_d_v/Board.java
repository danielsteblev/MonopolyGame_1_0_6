package ru.vsu.cs.util.steblev_d_v;

import ru.vsu.cs.util.steblev_d_v.cards.Card;

import java.util.*;

import static java.lang.Math.round;


public class Board implements GraphicsManagerInterface {
    private List<Card> board = new ArrayList<>();
    public static List<Integer> lastIndexes = new ArrayList<>();
    public static List<String> deletedELements = new ArrayList<>();
    public static List<String> deletedColors = new ArrayList<>();
    public static Board graphicsCopy = new Board();

    public void render() {

        // Рендер верхней строки
        List<TextArea> upperLine = new ArrayList<>();
        for (int k = 0; k < board.size() / 4 + 1; k++) {
            if (k == board.size() / 4) {
                TextArea textArea = new TextArea(board.get(board.size() / 4).getName(), BLACK_BOLD, board.get(k).getColor());
                textArea.sizeNormalize(board);
                upperLine.add(textArea);
                textArea.render();
                break;
            }
            TextArea textArea = new TextArea(board.get(k).getName(), BLACK_BOLD, board.get(k).getColor());
            textArea.sizeNormalize(board);
            upperLine.add(textArea);
            textArea.render();
        }
        System.out.println();

        // Рендер центра
        for (int k = board.size() / 4 + 1, j = board.size() - 1; k < board.size() / 2 && j > board.size() / 2 + 0.2 * board.size(); k++, j--) {
            TextArea textArea = new TextArea(board.get(j).getName(), BLACK_BOLD, board.get(j).getColor());
            TextArea textArea2 = new TextArea(board.get(k).getName(), BLACK_BOLD, board.get(k).getColor());
            textArea.sizeNormalize(board);
            textArea2.sizeNormalize(board);
            textArea.renderCentralLines(textArea, textArea2, board, upperLine);
        }

        // Рендер нижней строки
        for (int g = board.size() - board.size() / 4; g >= board.size() / 2; g--) {
            TextArea textArea = new TextArea(board.get(g).getName(), BLACK_BOLD, board.get(g).getColor());
            textArea.sizeNormalize(board);
            textArea.render();
        }
    }



    public void writePlayersMapping(List<Player> players) {
        // TODO: сделать графическую доску для рендеринга, не меняя основную
        if (GameSession.numberOfMove == 1) { // Проверка на 1 ход
            for (int i = 0; i < players.size(); i++) {
                lastIndexes.add(0);
                deletedELements.add(board.get(players.get(i).getCurrCardIndex()).getName());
                deletedColors.add(board.get(players.get(i).getCurrCardIndex()).getColor());
            }
        }
        for (int i = 0; i < players.size(); i++) {
            /*
            Возвращаем удалённый элемент на место, до этого записав его индекс и сам элемент в список.
             */
            board.get(lastIndexes.get(i)).setName(deletedELements.get(i));
            board.get(lastIndexes.get(i)).setColor(deletedColors.get(i));
            lastIndexes.set(i, players.get(i).getCurrCardIndex()); // Запоминаем новый индекс удалённого элемента
            deletedELements.set(i, board.get(players.get(i).getCurrCardIndex()).getName()); // Запоминаем новый удалённый элемент
            List<String> playerFace = Arrays.asList("\uD83D\uDC68", "\uD83D\uDC69",
                    "\uD83E\uDDD1", "\uD83E\uDDD2");
            board.get(players.get(i).getCurrCardIndex()).setName(playerFace.get(i) + players.get(i).getName());
            board.get(players.get(i).getCurrCardIndex()).setColor(GraphicsUtils.convertColorNameToConsole("cyan", true));
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






