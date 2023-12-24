package ru.vsu.cs.util.steblev_d_v;

import ru.vsu.cs.util.steblev_d_v.player.PlayerInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static ru.vsu.cs.util.steblev_d_v.GameSession.*;

public class GameMoveStatus {
    private int numberMove;
    private List<PlayerInterface> players;

    public GameMoveStatus(int numberMove, List<PlayerInterface> players) {
        this.numberMove = numberMove;
        this.players = players;
    }

    public List<PlayerInterface> getPlayers() {
        return players;
    }

    public static void getStatusAboutMove(Stack<GameMoveStatus> statuses, int numberMove){
        if(numberMove == 0){
            System.out.println(BLACK_BOLD + WHITE_BACKGROUND + "Ошибка! История ходов ещё неизвестна." + ANSI_RESET);
            return;
        }
        System.out.println(BLACK_BOLD + WHITE_BACKGROUND + "Статус хода №" + numberMove + ANSI_RESET);
        System.out.println(BLACK_BOLD + WHITE_BACKGROUND + "Cписок игроков: " + statuses.get(numberMove - 1).getPlayers().toString() + ANSI_RESET);
        for (int i = 0; i < statuses.size(); i++) {
            System.out.println(BLACK_BOLD + WHITE_BACKGROUND + "Баланс игрока под ником " + CYAN_BOLD_BRIGHT + statuses.get(numberMove - 1).getPlayers().get(i).getName() + ": $"
                    + statuses.get(numberMove - 1).getPlayers().get(i).getCash() + "k." + ANSI_RESET);
            System.out.println(BLACK_BOLD + WHITE_BACKGROUND + "Игрок "  + CYAN_BOLD_BRIGHT +statuses.get(numberMove - 1).getPlayers().get(i).getName() +
                    " владеет: " + statuses.get(numberMove - 1).getPlayers().get(i).getOwnedCompanies() + ANSI_RESET);
            System.out.println(BLACK_BOLD + WHITE_BACKGROUND + "Местоположение игрока " + CYAN_BOLD_BRIGHT + statuses.get(numberMove - 1).getPlayers().get(i).getName()
            + ":" + statuses.get(numberMove - 1).getPlayers().get(i).getCurrCardIndex() + ANSI_RESET);

        }
        System.out.println();

    }

    @Override
    public String toString() {
        return "GameMoveStatus{" +
                "numberMove=" + numberMove +
                ", players=" + players.toString() +
                '}';
    }
}
