package ru.vsu.cs.util.steblev_d_v.player;

import ru.vsu.cs.util.steblev_d_v.Dice;
import ru.vsu.cs.util.steblev_d_v.cards.CompanyCard;
import ru.vsu.cs.util.steblev_d_v.cards.JackpotCard;

import java.util.ArrayList;
import java.util.List;

import static ru.vsu.cs.util.steblev_d_v.GameSession.GREEN_BOLD_BRIGHT;
import static ru.vsu.cs.util.steblev_d_v.graphics.GraphicsManagerInterface.*;

public class Bot implements PlayerInterface {
    private String name;
    private int cash = 17500;
    private List<CompanyCard> ownedCompanies = new ArrayList<>();
    private boolean isInJail = false;
    private int currCardIndex = 0;

    public Bot(String name) {
        this.name = name;
    }

    @Override
    public int throwDice() {
        Dice dice1 = new Dice();
        Dice dice2 = new Dice();
        dice1.throwDice();
        dice2.throwDice();
        return dice1.getDiceResult() + dice2.getDiceResult();
    }

    @Override
    public void getJackpot() {
        JackpotCard.getJackpot(this);
    }

    @Override
    public int getCash() {
        return cash;
    }

    @Override
    public void setCash(int cash) {
        this.cash = cash;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
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

    @Override
    public void buyProcess(CompanyCard card) {
        if (this.getCash() > card.getPrice()) {
            this.setCash(this.getCash() - card.getPrice());
            card.setOwner(this);
            this.getOwnedCompanies().add(card);
            System.out.println(GREEN_BOLD_BRIGHT + "\n\uD83D\uDC73Богатый Дядюшка: " + ANSI_RESET + "Поздравляю тебя с приобретением " + card.getName() + ". Я думаю ты обязательно окупишься!");
            System.out.println(BLACK_BOLD + WHITE_BACKGROUND + "Игрок " + this.getName() + " приобрёл компанию " + card.getName() + "." + ANSI_RESET);
        }
        else return;
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
    public String toString() {
        return "Bot{" +
                "name='" + name + '\'' +
                ", cash=" + cash +
                ", ownedCompanies=" + ownedCompanies +
                ", isInJail=" + isInJail +
                ", currCardIndex=" + currCardIndex +
                '}';
    }
}
