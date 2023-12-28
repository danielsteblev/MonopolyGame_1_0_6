package ru.vsu.cs.util.steblev_d_v.cards;

import ru.vsu.cs.util.steblev_d_v.player.Player;


import java.util.ArrayList;
import java.util.List;

public class ChanceCard extends Card {

    private static List<Integer> chanceCardLocations = new ArrayList<>();
    public ChanceCard(int locationIndex, String color) {
        super("  ?  ", locationIndex, color);
        chanceCardLocations.add(locationIndex);
    }

    @Override
    public void doAction(Player player) {
        //todo action
    }
}
