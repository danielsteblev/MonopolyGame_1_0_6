package ru.vsu.cs.util.steblev_d_v.cards;
import ru.vsu.cs.util.steblev_d_v.player.Player;

import static ru.vsu.cs.util.steblev_d_v.GameSession.*;

public class CompanyCard extends Card {

    private int price;
    private int rentPrice;
    private Player owner;

    public CompanyCard(String name, int locationIndex, int price, int rentPrice, String color) {
        super(name, locationIndex, color);
        this.price = price;
        this.rentPrice = rentPrice;
        this.owner = null;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(int rentPrice) {
        this.rentPrice = rentPrice;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public boolean isLocationOwned() {
        return this.owner != null;
    }

    @Override
    public void doAction(Player player) {
        CompanyCard playerCardAfterMove1 = this;
        if (playerCardAfterMove1.isLocationOwned()) {
            System.out.println(GREEN_BOLD_BRIGHT + "\n\uD83D\uDC73Богатый Дядюшка: " + ANSI_RESET
                    + "Данное поле занято игроком " + playerCardAfterMove1.getOwner().getName() + ".\nТебе придётся оплатить ренту, " +
                    "чтобы пойти дальше! С тебя $" + playerCardAfterMove1.getRentPrice() + "k.");
            int rent = playerCardAfterMove1.getRentPrice();
            int cashAfterRent = player.getCash() - rent;
            System.out.println(BLACK_BOLD + WHITE_BACKGROUND
                    + "Ваш баланс: $" + player.getCash() + "k. Ваш баланс после оплаты ренты: $" + cashAfterRent + "k." + ANSI_RESET);
            player.setCash(cashAfterRent);
            playerCardAfterMove1.getOwner().setCash(playerCardAfterMove1.getOwner().getCash() + rent);

        } else {
            System.out.println(GREEN_BOLD_BRIGHT + "\n\uD83D\uDC73Богатый Дядюшка: " + ANSI_RESET + "Хей! У тебя есть: $" + player.getCash() + "k. Желаешь ли ты приобрести " + playerCardAfterMove1.getName() + " по цене: $" + playerCardAfterMove1.getPrice() + "k?");
            player.buyProcess(playerCardAfterMove1, player);
        }
    }
}
