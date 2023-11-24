package ru.vsu.cs.util.steblev_d_v.cards;

import ru.vsu.cs.util.steblev_d_v.Player;

import java.util.concurrent.ThreadLocalRandom;

public class JackpotCard extends Card {
    public JackpotCard( int locationIndex) {
        super("ДЖЕКПОТ", locationIndex);
    }

    private static int jackpot;

    public static int getJackpot() {
        return jackpot;
    }

    public static void getJackpot(Player player){
        jackpot = ThreadLocalRandom.current().nextInt(1000, 2000);
        player.setCash(player.getCash() + jackpot);
    }
}
