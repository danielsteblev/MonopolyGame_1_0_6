package ru.vsu.cs.util.steblev_d_v.player;
import ru.vsu.cs.util.steblev_d_v.cards.CompanyCard;

import java.util.List;

public interface PlayerInterface {
    int throwDice();
    void getJackpot();
    void buyProcess(CompanyCard card);
}

