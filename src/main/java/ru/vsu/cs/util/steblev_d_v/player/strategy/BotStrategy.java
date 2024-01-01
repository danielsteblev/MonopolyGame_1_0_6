package ru.vsu.cs.util.steblev_d_v.player.strategy;

import ru.vsu.cs.util.steblev_d_v.cards.CompanyCard;
import ru.vsu.cs.util.steblev_d_v.cards.JackpotCard;
import ru.vsu.cs.util.steblev_d_v.player.Player;

import static ru.vsu.cs.util.steblev_d_v.GameSession.GREEN_BOLD_BRIGHT;
import static ru.vsu.cs.util.steblev_d_v.graphics.GraphicsManagerInterface.*;

public class BotStrategy extends Player implements PlayerStrategy {
    @Override
    public void buyProcess(CompanyCard card, Player player) {
        if (player.getCash() > card.getPrice()) {
            player.setCash(player.getCash() - card.getPrice());
            card.setOwner(player);
            player.getOwnedCompanies().add(card);
            System.out.println(GREEN_BOLD_BRIGHT + "\n\uD83D\uDC73Богатый Дядюшка: " + ANSI_RESET + "Поздравляю тебя с приобретением " + card.getName() + ". Я думаю ты обязательно окупишься!");
            System.out.println(BLACK_BOLD + WHITE_BACKGROUND + "Игрок " + player.getName() + " приобрёл компанию " + card.getName() + "." + ANSI_RESET);
        } else return;
    }

    @Override
    public void getJackpot(Player player) {
        JackpotCard.getJackpot(player);
    }
}
