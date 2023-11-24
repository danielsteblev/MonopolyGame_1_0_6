package ru.vsu.cs.util.steblev_d_v.cards;

public class JailCard extends Card {
    private int type;
    public static int goToJailCardInd;
    public static int jailCardInd;

    public int getType() {
        return type;
    }

    public JailCard(int locationIndex, int type) {
        super("Тюряга", locationIndex);
        this.type = type;
        if(type == 0){
            jailCardInd = locationIndex;
        } else {
            goToJailCardInd = locationIndex;
        }
    }
}
