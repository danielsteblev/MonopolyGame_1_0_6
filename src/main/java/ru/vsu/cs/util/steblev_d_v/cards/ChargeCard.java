package ru.vsu.cs.util.steblev_d_v.cards;

import ru.vsu.cs.util.steblev_d_v.player.PlayerInterface;

public class ChargeCard extends Card {
    public ChargeCard(int locationIndex, String color) {
        super("\uD83D\uDCB5", locationIndex, color);
    }

    public void getCash(PlayerInterface player){
        int curCash = player.getCash();
        curCash = curCash - 2_000;
        player.setCash(curCash);
    }
}
