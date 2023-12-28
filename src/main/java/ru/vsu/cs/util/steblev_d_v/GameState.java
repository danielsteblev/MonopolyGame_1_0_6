package ru.vsu.cs.util.steblev_d_v;

import ru.vsu.cs.util.steblev_d_v.cards.CompanyCard;
import ru.vsu.cs.util.steblev_d_v.player.Player;
import ru.vsu.cs.util.steblev_d_v.player.PlayerInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static ru.vsu.cs.util.steblev_d_v.GameSession.*;

public class GameState {
    private int numberMove;
    private List<String> playersNames = new ArrayList<>();
    private List<Integer> playersCash = new ArrayList<>();
    private List<Integer> currCardInd = new ArrayList<>();
    private List<List<CompanyCard>> playerOwnedCompanies = new ArrayList<>();



    public GameState(int numberMove, List<Player> players) {
        for (int i = 0; i < players.size(); i++) {
            playersNames.add(players.get(i).getName());
            playersCash.add(players.get(i).getCash());
            currCardInd.add(players.get(i).getCurrCardIndex());
            playerOwnedCompanies.add(players.get(i).getOwnedCompanies());

        }
    }

    public int getNumberMove() {
        return numberMove;
    }

    public List<String> getPlayersNames() {
        return playersNames;
    }

    public List<Integer> getPlayersCash() {
        return playersCash;
    }

    public List<Integer> getCurrCardInd() {
        return currCardInd;
    }

    public List<List<CompanyCard>> getPlayerOwnedCompanies() {
        return playerOwnedCompanies;
    }
}
