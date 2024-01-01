package ru.vsu.cs.util.steblev_d_v.player.strategy;

import ru.vsu.cs.util.steblev_d_v.cards.CompanyCard;
import ru.vsu.cs.util.steblev_d_v.cards.JackpotCard;
import ru.vsu.cs.util.steblev_d_v.graphics.TextArea;
import ru.vsu.cs.util.steblev_d_v.player.Player;

import java.util.Scanner;

import static ru.vsu.cs.util.steblev_d_v.GameSession.GREEN_BOLD_BRIGHT;
import static ru.vsu.cs.util.steblev_d_v.graphics.GraphicsManagerInterface.*;
import static ru.vsu.cs.util.steblev_d_v.graphics.GraphicsManagerInterface.ANSI_RESET;

public class PersonStrategy extends Player implements PlayerStrategy {
    @Override
    public void buyProcess(CompanyCard card, Player player){
        Scanner scn = new Scanner(System.in);
        TextArea buyMessage = new TextArea("Введите ваш ответ (Y - для покупки, N - для отказа):", BLACK_BOLD, WHITE_BACKGROUND);
        buyMessage.render();
        String playerChoice = scn.next();
        System.out.println();
        if (playerChoice.equals("Y") || playerChoice.equals("y")) {
            int price = card.getPrice();
            if (player.getCash() < price) {
                System.out.println(GREEN_BOLD_BRIGHT + "\n\uD83D\uDC73Богатый Дядюшка: " + ANSI_RESET + "О нет! К сожалению, у тебя недостаточно средств. У меня есть пару советов, как заработать, я думаю они тебе помогут.");
                System.out.println(BLACK_BOLD + WHITE_BACKGROUND + "У вас недостаточно средств для покупки." + ANSI_RESET);
            } else {
                player.setCash(player.getCash() - price);
                card.setOwner(player);
                player.getOwnedCompanies().add(card);

                System.out.println(GREEN_BOLD_BRIGHT + "\n\uD83D\uDC73Богатый Дядюшка: " + ANSI_RESET + "Поздравляю тебя с приобретением " + card.getName() + ". Я думаю ты обязательно окупишься!");
                System.out.println(BLACK_BOLD + WHITE_BACKGROUND + "Игрок " + player.getName() + " приобрёл компанию " + card.getName() + "." + ANSI_RESET);
                // TODO сделать чтобы при покупке компании у карточки появлялась метка владельца
//                                            String result = board.getGraphicsBoard().get(player.getCurrCardIndex()) +  "0" ;
//                                            board.getGraphicsBoard().set(player.getCurrCardIndex(), result);

            }
        }
        if (playerChoice.equals("N") || playerChoice.equals("n")) {
            System.out.println(BLACK_BOLD + WHITE_BACKGROUND + "Вы успешно отказались от покупки компании " + card.getName() + "." + ANSI_RESET);
        }
    }

    @Override
    public void getJackpot() {
        Scanner scnLine = new Scanner(System.in);
        TextArea jackpotMessage = new TextArea("\uD83D\uDC8EНажмите любую кнопку, чтобы крутить барабан.", BLACK_BOLD, WHITE_BACKGROUND);
        jackpotMessage.render();
        scnLine.nextLine();
        System.out.println();
        JackpotCard.getJackpot(this);
    }
}
