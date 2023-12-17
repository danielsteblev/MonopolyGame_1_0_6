package ru.vsu.cs.util.steblev_d_v.player;

import ru.vsu.cs.util.steblev_d_v.cards.Card;
import ru.vsu.cs.util.steblev_d_v.cards.CompanyCard;

import java.util.List;

public interface PlayerInterface {
    int throwDice();
    void getJackpot();
    String getName();
    int getCurrCardIndex();
    int getCash();
    List<CompanyCard> getOwnedCompanies();
    void setCash(int cash);
    void setCurrCardIndex(int currCardIndex);
    void setInJail(boolean inJail);
    boolean isInJail();
    void buyProcess(CompanyCard card);

}

