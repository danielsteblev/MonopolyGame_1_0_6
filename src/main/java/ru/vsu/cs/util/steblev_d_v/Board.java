package ru.vsu.cs.util.steblev_d_v;

import ru.vsu.cs.util.steblev_d_v.cards.Card;

import java.util.*;





public class Board implements GraphicsManagerInterface {

    private List<Integer> lastIndexes = new ArrayList<>();
    private List<String> deletedELements = new ArrayList<>();
    private List<String> deletedColors = new ArrayList<>();
    private List<Card> board = new ArrayList<>();
    private List<String> graphicsBoard;
    private List<String> graphicsColorsBoard;


    public void checkGraphicsIsCreate() {
        if (graphicsBoard == null) {
            graphicsBoard = new ArrayList<>();
            graphicsColorsBoard = new ArrayList<>();
            for (int i = 0; i < board.size(); i++) {
                graphicsBoard.add(board.get(i).getName());
                graphicsColorsBoard.add(board.get(i).getColor());
            }
        }
    }

    public void render() {
       checkGraphicsIsCreate();
        // Рендер верхней строки
        List<TextArea> upperLine = new ArrayList<>();
        for (int k = 0; k < graphicsBoard.size() / 4 + 1; k++) {
            if (k == graphicsBoard.size() / 4) {
                TextArea textArea = new TextArea(graphicsBoard.get(graphicsBoard.size() / 4), BLACK_BOLD, graphicsColorsBoard.get(k));
                textArea.sizeNormalize(graphicsBoard);
                upperLine.add(textArea);
                textArea.render();
                break;
            }
            TextArea textArea = new TextArea(graphicsBoard.get(k), BLACK_BOLD, graphicsColorsBoard.get(k));
            textArea.sizeNormalize(graphicsBoard);
            upperLine.add(textArea);
            textArea.render();
        }
        System.out.println();

        // Рендер центра
        for (int k = graphicsBoard.size() / 4 + 1, j = graphicsBoard.size() - 1; k < graphicsBoard.size() / 2 && j > graphicsBoard.size() / 2 + 0.2 * graphicsBoard.size(); k++, j--) {
            TextArea textArea = new TextArea(graphicsBoard.get(j), BLACK_BOLD, graphicsColorsBoard.get(j));
            TextArea textArea2 = new TextArea(graphicsBoard.get(k), BLACK_BOLD, graphicsColorsBoard.get(k));
            textArea.sizeNormalize(graphicsBoard);
            textArea2.sizeNormalize(graphicsBoard);
            textArea.renderCentralLines(textArea, textArea2, upperLine);
        }

        // Рендер нижней строки
        for (int g = graphicsBoard.size() - graphicsBoard.size() / 4; g >= graphicsBoard.size() / 2; g--) {
            TextArea textArea = new TextArea(graphicsBoard.get(g), BLACK_BOLD, graphicsColorsBoard.get(g));
            textArea.sizeNormalize(graphicsBoard);
            textArea.render();
        }
    }


    public List<String> getGraphicsBoard() {
        return graphicsBoard;
    }

    public List<String> getGraphicsColorsBoard() {
        return graphicsColorsBoard;
    }

    public void writePlayersMapping(List<Player> players) {
        checkGraphicsIsCreate();
        if (GameSession.numberOfMove == 1) { // Проверка на 1 ход
            for (int i = 0; i < players.size(); i++) {
                lastIndexes.add(0);
                deletedELements.add(graphicsBoard.get(players.get(i).getCurrCardIndex()));
                deletedColors.add(graphicsColorsBoard.get(players.get(i).getCurrCardIndex()));
            }
        }
        for (int i = 0; i < players.size(); i++) {
            /*
            Возвращаем удалённый элемент на место, до этого записав его индекс и сам элемент в список.
             */
            graphicsBoard.set(lastIndexes.get(i), deletedELements.get(i));
            graphicsColorsBoard.set(lastIndexes.get(i), deletedColors.get(i));
            lastIndexes.set(i, players.get(i).getCurrCardIndex()); // Запоминаем новый индекс удалённого элемента
            deletedELements.set(i, graphicsBoard.get(players.get(i).getCurrCardIndex()));
            deletedColors.set(i, graphicsColorsBoard.get(players.get(i).getCurrCardIndex())); // Запоминаем новый удалённый элемент
            List<String> playerFace = Arrays.asList("\uD83D\uDC68", "\uD83D\uDC69",
                    "\uD83E\uDDD1", "\uD83E\uDDD2");
            graphicsBoard.set(players.get(i).getCurrCardIndex(), playerFace.get(i) + players.get(i).getName());
            graphicsColorsBoard.set(players.get(i).getCurrCardIndex(), GraphicsUtils.convertColorNameToConsole("cyan", true));
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






