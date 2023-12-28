package ru.vsu.cs.util.steblev_d_v.player;

import ru.vsu.cs.util.steblev_d_v.Dice;
import ru.vsu.cs.util.steblev_d_v.cards.CompanyCard;
import ru.vsu.cs.util.steblev_d_v.cards.JackpotCard;
import ru.vsu.cs.util.steblev_d_v.graphics.TextArea;

import java.util.Scanner;

import static ru.vsu.cs.util.steblev_d_v.GameSession.GREEN_BOLD_BRIGHT;
import static ru.vsu.cs.util.steblev_d_v.graphics.GraphicsManagerInterface.*;

public class Person extends Player implements PlayerInterface {
    public Person(String name) {
        this.setName(name);
    }


    public int throwDice() {
        Dice dice1 = new Dice();
        Dice dice2 = new Dice();
        Scanner scnLine = new Scanner(System.in);
        TextArea throwPersonDiceText = new TextArea("Нажмите любую кнопку для того, чтобы бросить кости.", BLACK_BOLD,
                WHITE_BACKGROUND);
        System.out.println();
        throwPersonDiceText.render();
        scnLine.nextLine();

        dice1.throwDice();
        dice2.throwDice();

        int diceResult = dice1.getDiceResult() + dice2.getDiceResult();

        return diceResult;
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

    @Override
    public void buyProcess(CompanyCard card) {
        Scanner scn = new Scanner(System.in);
        TextArea buyMessage = new TextArea("Введите ваш ответ (Y - для покупки, N - для отказа):", BLACK_BOLD, WHITE_BACKGROUND);
        buyMessage.render();
        String playerChoice = scn.next();
        System.out.println();
        if (playerChoice.equals("Y") || playerChoice.equals("y")) {
            int price = card.getPrice();
            if (this.getCash() < price) {
                System.out.println(GREEN_BOLD_BRIGHT + "\n\uD83D\uDC73Богатый Дядюшка: " + ANSI_RESET + "О нет! К сожалению, у тебя недостаточно средств. У меня есть пару советов, как заработать, я думаю они тебе помогут.");
                System.out.println(BLACK_BOLD + WHITE_BACKGROUND + "У вас недостаточно средств для покупки." + ANSI_RESET);
            } else {
                this.setCash(this.getCash() - price);
                card.setOwner(this);
                this.getOwnedCompanies().add(card);

                System.out.println(GREEN_BOLD_BRIGHT + "\n\uD83D\uDC73Богатый Дядюшка: " + ANSI_RESET + "Поздравляю тебя с приобретением " + card.getName() + ". Я думаю ты обязательно окупишься!");
                System.out.println(BLACK_BOLD + WHITE_BACKGROUND + "Игрок " + this.getName() + " приобрёл компанию " + card.getName() + "." + ANSI_RESET);
                // TODO сделать чтобы при покупке компании у карточки появлялась метка владельца
//                                            String result = board.getGraphicsBoard().get(player.getCurrCardIndex()) +  "0" ;
//                                            board.getGraphicsBoard().set(player.getCurrCardIndex(), result);

            }
        }
        if (playerChoice.equals("N") || playerChoice.equals("n")) {
            System.out.println(BLACK_BOLD + WHITE_BACKGROUND + "Вы успешно отказались от покупки компании " + card.getName() + "." + ANSI_RESET);
        }
    }
}
