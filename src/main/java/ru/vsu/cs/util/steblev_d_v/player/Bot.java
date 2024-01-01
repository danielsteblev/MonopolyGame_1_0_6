package ru.vsu.cs.util.steblev_d_v.player;

import ru.vsu.cs.util.steblev_d_v.player.strategy.BotStrategy;

public class Bot extends Player {
    public Bot(String name) {
        this.setName(name);
        this.playerStrategy = new BotStrategy();
    }
}
