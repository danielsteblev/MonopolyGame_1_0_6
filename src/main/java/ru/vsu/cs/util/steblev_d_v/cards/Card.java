package ru.vsu.cs.util.steblev_d_v.cards;

public class Card {
    String name;
    private int locationIndex = 0;

    public Card(String name, int locationIndex) {
        this.name = name;
        this.locationIndex = locationIndex;
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
}
