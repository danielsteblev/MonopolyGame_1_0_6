package ru.vsu.cs.util.steblev_d_v.cards;

import java.util.ArrayList;
import java.util.List;

public class ChanceCard extends Card {

    private static List<Integer> chanceCardLocations = new ArrayList<>();
    public ChanceCard(int locationIndex) {
        super("ШАНС", locationIndex);
        chanceCardLocations.add(locationIndex);
    }
}
