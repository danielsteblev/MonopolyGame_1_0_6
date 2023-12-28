package ru.vsu.cs.util.steblev_d_v.history;

import java.util.Stack;

public class GameHistory {
    private final Stack<Move> history = new Stack<>();
    public void saveMove(Move move){
        history.push(move);
    }

    public Move undoMove() {
        return history.isEmpty() ? null : history.pop();
    }


}
