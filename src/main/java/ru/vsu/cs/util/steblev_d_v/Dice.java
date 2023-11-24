package ru.vsu.cs.util.steblev_d_v;

public class Dice {
    private int diceResult = 0;

    public int getDiceResult() {
        return diceResult;
    }

    public void setDiceResult(int diceResult) {
        this.diceResult = diceResult;
    }

    public void throwDice() {
        diceResult = (int) ((Math.random() * (6 - 1)) + 1);
    }
}
