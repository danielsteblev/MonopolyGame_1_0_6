package ru.vsu.cs.util.steblev_d_v.cards;

import ru.vsu.cs.util.steblev_d_v.player.Player;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static ru.vsu.cs.util.steblev_d_v.GameSession.*;

public class JackpotCard extends Card{
    public JackpotCard( int locationIndex, String color) {
        super("JACKPOT\uD83C\uDFB0", locationIndex, color);
    }
    private static int jackpot;

    public static int getJackpot() {
        return jackpot;
    }

    public static void getJackpot(Player player){
        jackpot = ThreadLocalRandom.current().nextInt(1000, 2000);
        player.setCash(player.getCash() + jackpot);
    }

    @Override
    public void doAction(Player player) {
        System.out.println(GREEN_BOLD_BRIGHT + "\n\uD83D\uDC73Богатый Дядюшка: " + ANSI_RESET + "Ничего себе! Тебе повезло, ты попал на поле \uD83D\uDC51Джекпот\uD83D\uDC51. Давай проверим твою удачу!");
        JackpotCard playerCardAfterMove1 = this;
        player.getJackpot(player);
        System.out.println(GREEN_BOLD_BRIGHT + "\n\uD83D\uDC73Богатый Дядюшка: " + ANSI_RESET + getJackpotSymbols());
        System.out.println(BLACK_BOLD + WHITE_BACKGROUND + "Твой выигрыш: $" + JackpotCard.getJackpot() + "k. Твой баланс: $" + player.getCash() + "k." + ANSI_RESET);
    }


    public String getJackpotSymbols() {
        List<String> symbols = new ArrayList<>();
        symbols.add("\uD83C\uDF52");
        symbols.add("\uD83C\uDF53");
        symbols.add("\uD83C\uDF49");
        symbols.add("\uD83C\uDF4B");
        symbols.add("\uD83E\uDD5D");
        symbols.add("\uD83D\uDC8E");
        List<String> returnSymbols = new ArrayList<>();

        for (int j = 0; j < 3; j++) {
            int i = (int) ((Math.random() * (5 - 0)) + 1);
            returnSymbols.add(symbols.get(i));
        }
        String returnString = returnSymbols.toString()
                .replace(",", "")  //remove the commas
                .replace("[", "")  //remove the right bracket
                .replace("]", "")  //remove the left bracket
                .trim();
        return returnString;
    }
}
