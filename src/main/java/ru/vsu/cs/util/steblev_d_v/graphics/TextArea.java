package ru.vsu.cs.util.steblev_d_v.graphics;

import java.util.ArrayList;
import java.util.List;

public class TextArea implements GraphicsManagerInterface {
    /**
     * Класс для работы с выводом строк в консоль.
     * @param text содержание текстовой арены.
     * @param fontColor цвет текста.
     * @param backgroundColor цвет заднего фона текста.
     */
    private String text;
    private final String fontColor;
    private final String backgroundColor;

    public TextArea(String text, String fontColor, String backgroundColor) {
        this.text = text;
        this.fontColor = fontColor;
        this.backgroundColor = backgroundColor;
    }

    public void render() {
                System.out.print(backgroundColor + fontColor + text + ANSI_RESET + " ");
    }

    public void renderCentralLines(TextArea textArea, TextArea textArea1, List<TextArea> upperLine) {
        List<Integer> countSymbols = new ArrayList<>();
        StringBuilder spaces = new StringBuilder();
        int sumSymbols = 0;
        for (int i = 1; i < upperLine.size() - 1; i++) {
            sumSymbols += upperLine.get(i).getText().length();
            sumSymbols++;
        }
        for (int i = 0; i <= sumSymbols; i++) {
            spaces.append(" ");
        }
        System.out.println(textArea.backgroundColor + textArea.fontColor + textArea.text
                + ANSI_RESET + spaces
                + textArea1.backgroundColor + textArea1.fontColor + textArea1.text
                + ANSI_RESET);
    }


    /**
     *
     * @param board исходный board
     * Данный метод служит для нормализации размеров графической доски относительно текстовой арены
     *              максимального размера.
     */
    public void sizeNormalize(List<String> board) {
        ArrayList<Integer> cardsLength = new ArrayList<>();
        for (int i = 0; i < board.size(); i++) {
            cardsLength.add(board.get(i).length());
        }
        int maxPadding = GraphicsUtils.getMax(cardsLength);
        StringBuilder sb = new StringBuilder(maxPadding);
        sb.setLength((maxPadding - this.getText().length()) / 2);
        sb.append(this.getText());
        sb.setLength(maxPadding);
        String text = sb.toString().replace('\0', ' ');
        this.setText(text);
    }

    public void setText(String text) {
        this.text = text;
    }
    public String getText() {
        return text;
    }
}
