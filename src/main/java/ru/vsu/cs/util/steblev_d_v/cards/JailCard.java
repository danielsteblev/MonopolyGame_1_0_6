package ru.vsu.cs.util.steblev_d_v.cards;

import ru.vsu.cs.util.steblev_d_v.player.Player;

public class JailCard extends Card {
    private int type;
    public static int goToJailCardInd;
    public static int jailCardInd;

    public int getType() {
        return type;
    }

    public JailCard(int locationIndex, int type, String color) {
        super("JAIL\uD83D\uDC6E", locationIndex, color);
        this.type = type;
        if(type == 0){
            jailCardInd = locationIndex;
        } else {
            goToJailCardInd = locationIndex;
        }
    }

    @Override
    public void doAction(Player player) {
        JailCard playerCardAfterMove1 = this;
        if (playerCardAfterMove1.getType() != 0) {
            player.setInJail(true);
            player.setCurrCardIndex(JailCard.jailCardInd);
        }
    }
}
