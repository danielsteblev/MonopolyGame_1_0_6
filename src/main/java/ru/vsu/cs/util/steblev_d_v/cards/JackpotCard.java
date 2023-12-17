package ru.vsu.cs.util.steblev_d_v.cards;

import ru.vsu.cs.util.steblev_d_v.player.PlayerInterface;

import java.util.concurrent.ThreadLocalRandom;

public class JackpotCard extends Card {
    public JackpotCard( int locationIndex, String color) {
        super("JACKPOT\uD83C\uDFB0", locationIndex, color);
    }

    private static int jackpot;

    public static int getJackpot() {
        return jackpot;
    }

    public static void getJackpot(PlayerInterface player){
        jackpot = ThreadLocalRandom.current().nextInt(1000, 2000);
        player.setCash(player.getCash() + jackpot);
    }
}
