package ru.vsu.cs.util.steblev_d_v.player;

import ru.vsu.cs.util.steblev_d_v.cards.CompanyCard;
import ru.vsu.cs.util.steblev_d_v.player.strategy.PlayerStrategy;

import java.util.ArrayList;
import java.util.List;

public abstract class Player{
    PlayerStrategy playerStrategy;
    private String name;
    private int cash = 17500;
    private List<CompanyCard> ownedCompanies = new ArrayList<>();
    private boolean isInJail = false;
    private int currCardIndex = 0;


    public void buyProcess(CompanyCard card, Player player){
        playerStrategy.buyProcess(card, player);
    }

    public void getJackpot(Player player){
        playerStrategy.getJackpot(player);
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

    public List<CompanyCard> getOwnedCompanies() {
        return ownedCompanies;
    }

    public void setOwnedCompanies(List<CompanyCard> ownedCompanies) {
        this.ownedCompanies = ownedCompanies;
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
}
