package ru.vsu.cs.util.steblev_d_v.history;

import ru.vsu.cs.util.steblev_d_v.GameState;

public record Move(GameState gameStateBeforeMove, GameState gameStateAfterMove) {
}
