package ru.vsu.cs.util.steblev_d_v;

import ru.vsu.cs.util.steblev_d_v.cards.*;
import ru.vsu.cs.util.steblev_d_v.graphics.Board;
import ru.vsu.cs.util.steblev_d_v.player.*;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class GameSession {
    private List<PlayerInterface> players = new ArrayList<>();
    private List<GameMoveStatus> statuses = new ArrayList<>();
    List<List<PlayerInterface>> lists = new ArrayList<>();
    public static int numberOfMove = 0;
    Stack<GameMoveStatus> gameHistory = new Stack<>();
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String CYAN_BOLD_BRIGHT = "\033[1;96m";
    public static final String GREEN_BOLD_BRIGHT = "\033[1;92m";
    public static final String BLACK_BOLD = "\033[1;30m";
    public static final String WHITE_BACKGROUND = "\033[47m";
    Board board;

    public GameSession(Board board) {
        this.board = board;
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        Scanner scnLine = new Scanner(System.in);
        int playerNum;

        String answer;
        // Вариции ответов на неправильное кол-во игроков
        List<String> answersToErrorNumOfPersons = new ArrayList<>();
        answersToErrorNumOfPersons.add(GREEN_BOLD_BRIGHT + "\n\uD83D\uDC73Богатый Дядюшка: " + ANSI_RESET + "Упс! Ты указал неверное количество игроков. Попробуй ещё раз ввести значение от 2 до 4!");
        answersToErrorNumOfPersons.add(GREEN_BOLD_BRIGHT + "\n\uD83D\uDC73Богатый Дядюшка: " + ANSI_RESET + "Что-то пошло не так. Повторюсь, за стол помещается только от 2 до 4 игроков! Попробуй ещё раз.");

        System.out.println(GREEN_BOLD_BRIGHT + "\uD83D\uDC73Богатый Дядюшка: " + ANSI_RESET + "Добро пожаловать в мир недвижимости и финансовых инвестиций!" + "\nЯ буду твоим помощником в данной игре, называй меня Богатый Дядюшка. Как могу к тебе обращаться?");
        System.out.println(BLACK_BOLD + WHITE_BACKGROUND + "Введите ваше имя:" + ANSI_RESET);
        String personName = scanner.next();
        System.out.println(CYAN_BOLD_BRIGHT + "\nВы: " + ANSI_RESET + "Меня зовут " + personName + ". " + "Куда я попал, Богатый Дядюшка?");
        System.out.println(GREEN_BOLD_BRIGHT + "\n\uD83D\uDC73Богатый Дядюшка: " + ANSI_RESET + "Рад знакомству, " + personName + "." + "\nВ игре Монополия вы сможете поработать богатырём настоящего бизнеса, строить империи и покупать самые выгодные сделки.\nГотовы ли вы стать настоящим магнатом собственности и составить конкуренцию своим соперникам?");
        do {
            System.out.println(BLACK_BOLD + WHITE_BACKGROUND + "Подтвердите свою готовность (Y - да, N - нет):" + ANSI_RESET);
            answer = scanner.next();
            if (answer.equals("N") || answer.equals("n")) {
                System.exit(1);
            }
            if (answer.equals("Y") || answer.equals("y")) {
                System.out.println(CYAN_BOLD_BRIGHT + "\nВы: " + ANSI_RESET + "О да! Я очень хочу узнать что же это за игра. Давайте уже начнём. ");
            } else {
                System.out.println(GREEN_BOLD_BRIGHT + "\n\uD83D\uDC73Богатый Дядюшка: " + ANSI_RESET + "Видимо ты ошибся! Попробуй ответить снова.");
            }

        } while (!answer.equals("Y"));


        System.out.println(GREEN_BOLD_BRIGHT + "\n\uD83D\uDC73Богатый Дядюшка: " + ANSI_RESET + "Для начала определимся сколько у тебя друзей. Всего вмещается за стол от 1 до 4 игроков. Определись, сколько вас, " + personName);
        do {
            System.out.println(BLACK_BOLD + WHITE_BACKGROUND + "Введите количество игроков от 2 до 4:" + ANSI_RESET);
            playerNum = scanner.nextInt();
            if (playerNum < 2 || playerNum > 4) {
                System.out.println(answersToErrorNumOfPersons.get(ThreadLocalRandom.current().nextInt(0, 1 + 1)));
            }
        } while (playerNum < 2 || playerNum > 4);


        int i = 1;
        do {
            System.out.println(GREEN_BOLD_BRIGHT + "\n\uD83D\uDC73Богатый Дядюшка: " + ANSI_RESET + "Теперь определимся кто будет играть.");
            System.out.println(BLACK_BOLD + WHITE_BACKGROUND + "Введите статус игрока " + i + " (player/bot): " + ANSI_RESET);
            String statusPlayer = scnLine.next();
            List<String> playerFace = Arrays.asList("\uD83D\uDC68", "\uD83D\uDC69",
                    "\uD83E\uDDD1", "\uD83E\uDDD2");
            SimplePlayerFactory playerFactory = new SimplePlayerFactory();
            switch (statusPlayer) {
                case "player":
                    System.out.println(BLACK_BOLD + WHITE_BACKGROUND + "Введите имя игрока " + i + ":" + ANSI_RESET);
                    String namePlayer = playerFace.get(i - 1) + scnLine.next();
                    if (nameIsOccupied(players, namePlayer)) {
                        System.out.println(GREEN_BOLD_BRIGHT + "\n\uD83D\uDC73Богатый Дядюшка: " + ANSI_RESET + "Ой! Похоже это имя уже занято. Попробуй ещё раз.");
                        continue;
                    }
                    PlayerInterface person = playerFactory.createPlayer(PlayerType.PERSON, namePlayer);
                    players.add(person);

                    i++;
                    break;
                case "bot":
                    PlayerInterface bot = playerFactory.createPlayer(PlayerType.BOT, "\uD83E\uDD16bot" + i);
                    players.add(bot);
                    i++;
                    break;
            }
        } while (i <= playerNum);
        statuses.add(new GameMoveStatus(numberOfMove, players));
        while (gameCoutined(players)) {
            for (PlayerInterface player : players) {
                int answerMenuPlayer = 0;
                while (!(answerMenuPlayer == 1)) {
                    System.out.println(BLACK_BOLD + WHITE_BACKGROUND + "Панель управления игрока " + WHITE_BACKGROUND + CYAN_BOLD_BRIGHT + player.getName() + "                " + ANSI_RESET);
                    System.out.println(BLACK_BOLD + WHITE_BACKGROUND + "1. Cледующий ход." + "                         " + ANSI_RESET);
                    System.out.println(BLACK_BOLD + WHITE_BACKGROUND + "2. Баланс." + "                               " + ANSI_RESET);
                    System.out.println(BLACK_BOLD + WHITE_BACKGROUND + "3. Информация о ходах." + "               " + ANSI_RESET);
                    System.out.println(BLACK_BOLD + WHITE_BACKGROUND + "4. Открыть мини-карту." + "                       " + ANSI_RESET);
                    System.out.println(BLACK_BOLD + WHITE_BACKGROUND + "Введите значение (от 1 до 4):" + "                " + ANSI_RESET);
                    answerMenuPlayer = scanner.nextInt();
                    switch (answerMenuPlayer) {
                        case 1:
                            System.out.println(GREEN_BOLD_BRIGHT + "\n\uD83D\uDC73Богатый Дядюшка: " + ANSI_RESET + "Игрок под именем " + player.getName() + " сейчас твой ход! Бросай кубики!");
                            if (player.isInJail()) {
                                System.out.println(GREEN_BOLD_BRIGHT + "\n\uD83D\uDC73Богатый Дядюшка: " + ANSI_RESET + "О нет! Кажется игрок " + player.getName() + " сейчас в тюрьме.");
                                player.setInJail(false);
                                continue;
                            }

                            // Бросаем кости
                            int diceResult = player.throwDice();
                            System.out.println(BLACK_BOLD + WHITE_BACKGROUND + "Вам выпало: " + diceResult + ANSI_RESET);


                            // Получаем новую карту, на которой стоит игрок
                            int playerNewCardIndex = player.getCurrCardIndex() + diceResult;

                            // Проверка на прохождение круга
                            if (playerNewCardIndex >= board.getBoard().size()) {
                                System.out.println(GREEN_BOLD_BRIGHT + "\n\uD83D\uDC73Богатый Дядюшка: " + ANSI_RESET + "Игрок под ником " + player.getName() +
                                        " получает $2000k за проход круга!");
                                System.out.println(BLACK_BOLD + WHITE_BACKGROUND + "Зачисление: $2000k. Баланс игрока " + player.getName() +
                                        ": $" + player.getCash() + "k." + ANSI_RESET);
                                player.setCash(player.getCash() + 2000);
                                playerNewCardIndex = playerNewCardIndex % board.getBoard().size();
                            }


                            player.setCurrCardIndex(playerNewCardIndex);
                            int playerCardIndexAfterMove = player.getCurrCardIndex();
                            Card playerCardAfterMove = board.getBoard().get(playerCardIndexAfterMove);
                            System.out.println(GREEN_BOLD_BRIGHT + "\n\uD83D\uDC73Богатый Дядюшка: " + ANSI_RESET + "Ну давай посмотрим, что там у нас!");
                            System.out.println(BLACK_BOLD + WHITE_BACKGROUND + "Сейчас ты находишься на поле: " + playerCardAfterMove.getName() + ANSI_RESET);



                            playerCardAfterMove.doAction(player); // Что-то делаем в зависимости от типа карты
                            numberOfMove++;
                            gameHistory.push(new GameMoveStatus(numberOfMove, players));
                            board.writePlayersMapping(players);
                            System.out.println();
                            System.out.println();
                            lists.add(players);
                            break;

                        case 2:
                            System.out.println(GREEN_BOLD_BRIGHT + "\n\uD83D\uDC73Богатый Дядюшка: " + ANSI_RESET + "И снова ты, " + player.getName() + ", сейчас глянем что там у тебя по деньгам.");
                            System.out.println(BLACK_BOLD + WHITE_BACKGROUND + "Ваш баланс: $" + player.getCash() + "k." + ANSI_RESET);
                            System.out.println();
                            System.out.println(BLACK_BOLD + WHITE_BACKGROUND + "Для возврата в меню нажмите любую кнопку." + ANSI_RESET);
                            scnLine.nextLine();
                            break;


                        case 3:

                            System.out.println(BLACK_BOLD + WHITE_BACKGROUND + "1. Получить информацию о ходе." + "               " + ANSI_RESET);
                            System.out.println(BLACK_BOLD + WHITE_BACKGROUND + "2. Откатить ходы." + "               " + ANSI_RESET);
                            int answerMovesMenuPlayer = scanner.nextInt();
                            switch (answerMovesMenuPlayer) {
                                case 1:
                                    if (numberOfMove < 1) {
                                        System.out.println(BLACK_BOLD + WHITE_BACKGROUND + "История ходов пока неизвестна! Попробуйте позже." + ANSI_RESET);
                                        System.out.println();
                                        break;
                                    }

                                    System.out.println(GREEN_BOLD_BRIGHT + "\n\uD83D\uDC73Богатый Дядюшка: " + ANSI_RESET + "О каком ходе хочешь получить информацию?");
                                    System.out.println(BLACK_BOLD + WHITE_BACKGROUND + "Введите номер хода от 1 до " + numberOfMove + "." + "Текущий номер хода: " + numberOfMove + ANSI_RESET);
                                    int searchNumOfMove = scanner.nextInt();
                                    GameMoveStatus.getStatusAboutMove(gameHistory, searchNumOfMove);
                                    break;

                                case 2:
                                    if (numberOfMove < 1) {
                                        System.out.println(BLACK_BOLD + WHITE_BACKGROUND + "История ходов пока неизвестна! Попробуйте позже." + ANSI_RESET);
                                        System.out.println();
                                        break;
                                    }
                                    System.out.println(BLACK_BOLD + WHITE_BACKGROUND + "Введите на сколько ходов хотите откатить  от 1 до " + numberOfMove + "." + "Текущий номер хода: " + numberOfMove + ANSI_RESET);
                                    int answerM = scanner.nextInt();
                                    int n = gameHistory.size();
                                    for (int j = n; j > n - answerM; j--) {
                                        gameHistory.pop();
                                    }
                                    numberOfMove = gameHistory.size();

                                    for (int j = 0; j < players.size() - 1; j++) {
                                        players.set(j, gameHistory.peek().getPlayers().get(j));
                                    }
                                    board.writePlayersMapping(players);
                                    break;
                            }
                            break;

                        case 4:
                            board.render();
                            System.out.println();
                            System.out.println();
                            System.out.println(BLACK_BOLD + WHITE_BACKGROUND + "Для возврата в меню нажмите любую кнопку." + ANSI_RESET);
                            scnLine.nextLine();
                            System.out.println();
                            break;

                        default:
                            return;


                        case 5:


//                        case 6:
//                            List<Card> canBuild = new ArrayList<>();
//                            for (int j = 0; j < player.getOwnedCompanies().size(); j++) {
//                                int count = 0;
//                                for (int k = 1; k < player.getOwnedCompanies().size(); k++) {
//                                    if (player.getOwnedCompanies().get(i).getColor().equals(
//                                            player.getOwnedCompanies().get(k).getColor())) {
//                                        canBuild.add(player.getOwnedCompanies().get(i));
//                                        count++;
//                                    }
//                                }
//                                if (count == 3) {
//                                    System.out.println("sucsess");
//                                }
//                            }
                    }
                }
            }
        }
    }


    public boolean gameCoutined(List<PlayerInterface> players) {
        Iterator<PlayerInterface> iterPlayers = players.iterator();
        while (iterPlayers.hasNext()) {
            PlayerInterface player = iterPlayers.next();
            if (player.getCash() < 0) {
                if (player.getOwnedCompanies().size() > 0) {
                    System.out.println(GREEN_BOLD_BRIGHT + "\n\uD83D\uDC73Богатый Дядюшка: " + ANSI_RESET + "О нет! Кажется игрок " + player.getName() + " в долгах! Мне придётся отобрать принадлежащие тебе компании и продать их.");
                    List<CompanyCard> playersOwnedCompanies = player.getOwnedCompanies();
                    Iterator<CompanyCard> iterOwnedCompanies = playersOwnedCompanies.iterator();
                    while (iterOwnedCompanies.hasNext()) {
                        CompanyCard companyCard = iterOwnedCompanies.next();
                        int price = companyCard.getPrice();
                        player.setCash(player.getCash() + price);
                        System.out.println(GREEN_BOLD_BRIGHT + "\n\uD83D\uDC73Богатый Дядюшка: " + ANSI_RESET + "Компания " + companyCard.getName() + " игрока под ником " + player.getName() + " была продана мною.\nТеперь у игрока " + player.getName() + " баланс следующий: $" + player.getCash() + "k");
                        companyCard.setOwner(null);
                        iterOwnedCompanies.remove();
                        if (player.getCash() >= 0) {
                            break;
                        }
                    }
                }
                if (player.getCash() < 0) {
                    System.out.println(GREEN_BOLD_BRIGHT + "\n\uD83D\uDC73Богатый Дядюшка: " + ANSI_RESET + "Игрок под ником " + player.getName() + " не владеет никакими компаниями и не имеет средств! Он объявляется банкротом.");
                    iterPlayers.remove();
                }
            }
        }
        if (players.size() == 1) {
            PlayerInterface winner = players.get(0);
            System.out.println(GREEN_BOLD_BRIGHT + "\n\uD83D\uDC73Богатый Дядюшка: " + ANSI_RESET + "УРАААА! Игрок под ником " + winner.getName() + " становится победителем! Мои поздравления! Я до конца верил в тебя, " + winner.getName());
            return false;
        } else {
            return true;
        }
    }

    public boolean nameIsOccupied(List<PlayerInterface> players, String name) {
        for (PlayerInterface p : players) {
            if (p.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }



}




