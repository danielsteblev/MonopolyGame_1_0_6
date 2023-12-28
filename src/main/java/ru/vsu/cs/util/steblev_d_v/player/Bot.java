package ru.vsu.cs.util.steblev_d_v.player;

import ru.vsu.cs.util.steblev_d_v.Dice;
import ru.vsu.cs.util.steblev_d_v.cards.CompanyCard;
import ru.vsu.cs.util.steblev_d_v.cards.JackpotCard;

import static ru.vsu.cs.util.steblev_d_v.GameSession.GREEN_BOLD_BRIGHT;
import static ru.vsu.cs.util.steblev_d_v.graphics.GraphicsManagerInterface.*;

public class Bot extends Player implements PlayerInterface {
    public Bot(String name) {
        this.setName(name);
    }


    @Override
    public void getJackpot() {
        JackpotCard.getJackpot(this);
    }


    @Override
    public void buyProcess(CompanyCard card) {
        if (this.getCash() > card.getPrice()) {
            this.setCash(this.getCash() - card.getPrice());
            card.setOwner(this);
            this.getOwnedCompanies().add(card);
            System.out.println(GREEN_BOLD_BRIGHT + "\n\uD83D\uDC73Богатый Дядюшка: " + ANSI_RESET + "Поздравляю тебя с приобретением " + card.getName() + ". Я думаю ты обязательно окупишься!");
            System.out.println(BLACK_BOLD + WHITE_BACKGROUND + "Игрок " + this.getName() + " приобрёл компанию " + card.getName() + "." + ANSI_RESET);
        } else return;
    }
}
