package ru.vsu.cs.util.steblev_d_v.cards;

import ru.vsu.cs.util.steblev_d_v.Player;

public class ChargeCard extends Card {
    public ChargeCard(int locationIndex) {
        super(null, locationIndex);
    }

    public void getCash(Player player){
        int curCash = player.getCash();
        curCash = curCash - 2_000;
        player.setCash(curCash);
    }
}
