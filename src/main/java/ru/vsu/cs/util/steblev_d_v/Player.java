package ru.vsu.cs.util.steblev_d_v;

import ru.vsu.cs.util.steblev_d_v.cards.CompanyCard;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Player {
    private String figure;
    private String name;
    private int cash = 17500;
    private List<CompanyCard> ownedCompanies = new ArrayList<>();
    private boolean isInJail = false;
    private int currCardIndex = 0;

    public Player(String name) {
        this.name = name;
    }
    public List<CompanyCard> getOwnedCompanies() {
        return ownedCompanies;
    }

    public String getFigure() {
        return figure;
    }
    public void setFigure(String figure) {
        this.figure = figure;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public boolean isInJail() {
        return isInJail;
    }

    public void setInJail(boolean inJail) {
        isInJail = inJail;
    }

    public int getCurrCardIndex() {
        return currCardIndex;
    }

    public void setCurrCardIndex(int currCardIndex) {
        this.currCardIndex = currCardIndex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return  name;
    }
}
