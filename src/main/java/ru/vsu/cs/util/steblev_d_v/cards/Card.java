package ru.vsu.cs.util.steblev_d_v.cards;

import ru.vsu.cs.util.steblev_d_v.player.Player;
import ru.vsu.cs.util.steblev_d_v.player.PlayerInterface;

import javax.swing.plaf.PanelUI;

public class Card {
    String name;
    private int locationIndex = 0;
    String color;

    public Card(String name, int locationIndex, String color) {
        this.name = name;
        this.locationIndex = locationIndex;
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLocationIndex() {
        return locationIndex;
    }

    public void setLocationIndex(int locationIndex) {
        this.locationIndex = locationIndex;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public void doAction(Player player) {

    }
}
