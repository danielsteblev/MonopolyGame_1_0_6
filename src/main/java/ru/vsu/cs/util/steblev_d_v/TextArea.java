package ru.vsu.cs.util.steblev_d_v;

import ru.vsu.cs.util.steblev_d_v.cards.Card;

import java.util.ArrayList;
import java.util.List;

public class TextArea implements GraphicsManagerInterface {
    private String text;
    private final String fontColor;
    private final String backgroundColor;
    private String print;

    public TextArea(String text, String fontColor, String backgroundColor, String print) {
        this.text = text;
        this.fontColor = fontColor;
        this.backgroundColor = backgroundColor;
        this.print = print;
    }

    public void render() {
        switch (this.getPrint()) {
            case "row":
                System.out.print(backgroundColor + fontColor + text + ANSI_RESET + " ");
                break;

            case "col":
                System.out.println(backgroundColor + fontColor + text + ANSI_RESET + " ");
                break;
        }
    }

    public void renderCentralLines(TextArea textArea, TextArea textArea1, List<Card> board) {
        List<Integer> countSymbols = new ArrayList<>();
        StringBuilder spaces = new StringBuilder();
        int sum = 0;
        for (int i = 1; i <= board.size() / 4; i++) {
            sum += board.get(i).getName().length();
            sum++;
        }
        for (int i = 0; i <= sum; i++) {
            spaces.append(" ");
        }
        System.out.println(textArea.backgroundColor + textArea.fontColor + textArea.text
                + ANSI_RESET + spaces
                + textArea1.backgroundColor + textArea1.fontColor + textArea1.text
                + ANSI_RESET);
    }


    public void sizeNormalize(List<Card> board) {
        ArrayList<Integer> cardsLength = new ArrayList<>();
        for (int i = 0; i < board.size(); i++) {
            cardsLength.add(board.get(i).getName().length());
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
    public String getPrint() {
        return print;
    }
}
