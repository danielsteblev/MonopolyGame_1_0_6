package ru.vsu.cs.util.steblev_d_v.player.strategy;

import ru.vsu.cs.util.steblev_d_v.cards.CompanyCard;
import ru.vsu.cs.util.steblev_d_v.player.Player;

public interface PlayerStrategy {
     void buyProcess(CompanyCard card, Player player);
    void getJackpot(Player player);
}
