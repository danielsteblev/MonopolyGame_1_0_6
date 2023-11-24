package ru.vsu.cs.util.steblev_d_v.cards;

import ru.vsu.cs.util.steblev_d_v.Player;

public class CompanyCard extends Card {

    private int price;
    private int rentPrice;
    private Player owner;

    public CompanyCard(String name, int locationIndex, int price, int rentPrice) {
        super(name, locationIndex);
        this.price = price;
        this.rentPrice = rentPrice;
        this.owner = null;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(int rentPrice) {
        this.rentPrice = rentPrice;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public boolean isLocationOwned() {
        return this.owner != null;
    }
}
