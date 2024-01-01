package ru.vsu.cs.util.steblev_d_v.player;

import ru.vsu.cs.util.steblev_d_v.player.strategy.PersonStrategy;

public class Person extends Player {
    public Person(String name) {
        this.setName(name);
        this.playerStrategy = new PersonStrategy();
    }
}
