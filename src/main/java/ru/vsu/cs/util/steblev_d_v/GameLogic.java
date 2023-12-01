package ru.vsu.cs.util.steblev_d_v;

import ru.vsu.cs.util.steblev_d_v.cards.*;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class GameLogic {
    private List<Player> players = new ArrayList<>();
    private List<GameMoveStatus> statuses = new ArrayList<>();
    public static int numberOfMove = 1;
    private List<Card> cardsOfMap = new ArrayList<>();
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String CYAN_BOLD_BRIGHT = "\033[1;96m";

    public static final String GREEN_BOLD_BRIGHT = "\033[1;92m";
    public static final String BLACK_BOLD = "\033[1;30m";
    public static final String WHITE_BACKGROUND = "\033[47m";
    public static final String WHITE_BACKGROUND_BRIGHT = "\033[0;107m";   // WHITE

    Dice dice1 = new Dice();
    Dice dice2 = new Dice();

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
            System.out.println(GREEN_BOLD_BRIGHT + "\n\uD83D\uDC73Богатый Дядюшка: " + ANSI_RESET + "Теперь определимся с именами игроков за столом.");
            System.out.println(BLACK_BOLD + WHITE_BACKGROUND + "Введите имя игрока " + i + ": " + ANSI_RESET);
            String namePlayer = scnLine.next();
            if (nameIsOccupied(players, namePlayer)) {
                System.out.println(GREEN_BOLD_BRIGHT + "\n\uD83D\uDC73Богатый Дядюшка: " + ANSI_RESET + "Ой! Похоже это имя уже занято. Попробуй ещё раз.");
                continue;
            }
//            System.out.println(GREEN_BOLD_BRIGHT + "\n\uD83D\uDC73Богатый Дядюшка: " + ANSI_RESET + "Теперь давай выберем фигурку, которой ты будешь играть.");
//            System.out.println(BLACK_BOLD + WHITE_BACKGROUND + "Выберите фигуру игрока " + namePlayer + ": " + ANSI_RESET);
//            System.out.println(BLACK_BOLD + WHITE_BACKGROUND + "1. \uD83D\uDC53" + ANSI_RESET);
//            System.out.println(BLACK_BOLD + WHITE_BACKGROUND + "2. \uD83D\uDC51" + ANSI_RESET);
//            System.out.println(BLACK_BOLD + WHITE_BACKGROUND + "3. \uD83D\uDCF7" + ANSI_RESET);
//            System.out.println(BLACK_BOLD + WHITE_BACKGROUND + "4. ✈\uFE0F" + ANSI_RESET);
//            int answerFigure = scanner.nextInt();
//            String figurePlayer = null;
//            switch (answerFigure){
//                case 1:
//                    figurePlayer = "\uD83D\uDC53";
//                    break;
//                case 2:
//                    figurePlayer = "\uD83D\uDC51";
//                    break;
//                case 3:
//                    figurePlayer = "\uD83D\uDCF7";
//                    break;
//                case 4:
//                    figurePlayer = "✈\uFE0F";
//                    break;
//                default:
//                    System.out.println(BLACK_BOLD + WHITE_BACKGROUND + "Вы ввели неправильное значение! Попробуйте повторить попытку." + ANSI_RESET);
//            }

            players.add(new Bot(namePlayer));
            i++;
        } while (i <= playerNum);


        generateMap();

        System.out.println();


        while (gameCoutined(players)) {
            for (Player player : players) {
                System.out.println(BLACK_BOLD + WHITE_BACKGROUND + "Панель управления игрока " + WHITE_BACKGROUND + CYAN_BOLD_BRIGHT + player.getName() + "                " + ANSI_RESET);
                System.out.println(BLACK_BOLD + WHITE_BACKGROUND + "1. Вернуться в игру." + "                         " + ANSI_RESET );
                System.out.println(BLACK_BOLD + WHITE_BACKGROUND + "2. Мой баланс."+  "                               " + ANSI_RESET);
                System.out.println(BLACK_BOLD + WHITE_BACKGROUND + "3. Получить информацию о ходе." + "               " +  ANSI_RESET);
                System.out.println(BLACK_BOLD + WHITE_BACKGROUND + "4. Открыть мини-карту." + "                       " + ANSI_RESET);
                System.out.println(BLACK_BOLD + WHITE_BACKGROUND + "Введите значение (от 1 до 4):" + "                " + ANSI_RESET);
                int answerMenuPlayer = scanner.nextInt();
                switch (answerMenuPlayer) {
                    case 1:
                        System.out.println(GREEN_BOLD_BRIGHT + "\n\uD83D\uDC73Богатый Дядюшка: " + ANSI_RESET + "Игрок под именем " + player.getName() + " сейчас твой ход! Бросай кубики!");
                        if (player.isInJail()) {
                            System.out.println(GREEN_BOLD_BRIGHT + "\n\uD83D\uDC73Богатый Дядюшка: " + ANSI_RESET + "О нет! Кажется игрок " + player.getName() + " сейчас в тюрьме.");
                            player.setInJail(false);
                            continue;
                        }
                        System.out.println(BLACK_BOLD + WHITE_BACKGROUND + "Нажмите любую кнопку для того, чтобы бросить кости." + ANSI_RESET);
                        scnLine.nextLine();
                        dice1.throwDice();
                        dice2.throwDice();
                        System.out.println();

                        int diceResult = dice1.getDiceResult() + dice2.getDiceResult();
                        switch (diceResult) {
                            case 2:
                                System.out.println(BLACK_BOLD + WHITE_BACKGROUND + "⚀⚀ Тебе выпало: 2" + ANSI_RESET);
                                break;
                            case 3:
                                System.out.println(BLACK_BOLD + WHITE_BACKGROUND + "⚀⚁ Тебе выпало: 3" + ANSI_RESET);
                                break;
                            case 4:
                                System.out.println(BLACK_BOLD + WHITE_BACKGROUND + "⚂⚀ Тебе выпало: 4" + ANSI_RESET);
                                break;
                            case 5:
                                System.out.println(BLACK_BOLD + WHITE_BACKGROUND + "⚂⚁ Тебе выпало: 5" + ANSI_RESET);
                                break;
                            case 6:
                                System.out.println(BLACK_BOLD + WHITE_BACKGROUND + "⚄⚀ Тебе выпало: 6" + ANSI_RESET);
                                break;
                            case 7:
                                System.out.println(BLACK_BOLD + WHITE_BACKGROUND + "⚃⚂ Тебе выпало: 7" + ANSI_RESET);
                                break;
                            case 8:
                                System.out.println(BLACK_BOLD + WHITE_BACKGROUND + "⚂⚄ Тебе выпало: 8" + ANSI_RESET);
                                break;
                            case 9:
                                System.out.println(BLACK_BOLD + WHITE_BACKGROUND + "⚅⚂ Тебе выпало: 9" + ANSI_RESET);
                                break;
                            case 10:
                                System.out.println(BLACK_BOLD + WHITE_BACKGROUND + "⚄⚄ Тебе выпало: 10" + ANSI_RESET);
                                break;
                            case 11: ;
                                System.out.println(BLACK_BOLD + WHITE_BACKGROUND + "⚅⚄ Тебе выпало: 11" + ANSI_RESET);
                                break;
                            case 12:
                                System.out.println(BLACK_BOLD + WHITE_BACKGROUND + "⚅⚅ Тебе выпало: 12" + ANSI_RESET);
                                break;
                        }
                        int playerNewCardIndex = player.getCurrCardIndex() + diceResult;
//                        numberOfMove++;
                        if (playerNewCardIndex >= cardsOfMap.size()) {
                            System.out.println(GREEN_BOLD_BRIGHT + "\n\uD83D\uDC73Богатый Дядюшка: " + ANSI_RESET + "Игрок под ником " + player.getName() +
                                    " получает $2000k за проход круга!");
                            System.out.println(BLACK_BOLD + WHITE_BACKGROUND + "Зачисление: $2000k. Баланс игрока " + player.getName()+
                                    ": $" + player.getCash() + "k." + ANSI_RESET);

                            player.setCash(player.getCash() + 2000);
                            playerNewCardIndex = playerNewCardIndex % cardsOfMap.size();
                        }
                        player.setCurrCardIndex(playerNewCardIndex);
                        int playerCardIndexAfterMove = player.getCurrCardIndex();
                        Card playerCardAfterMove = cardsOfMap.get(playerCardIndexAfterMove);
                        System.out.println(GREEN_BOLD_BRIGHT + "\n\uD83D\uDC73Богатый Дядюшка: " + ANSI_RESET + "Ну давай посмотрим, что там у нас!");
                        System.out.println(BLACK_BOLD + WHITE_BACKGROUND + "Сейчас ты находишься на поле: " + playerCardAfterMove.getName() + ANSI_RESET);
                        Board.writePlayersMapping(players);

                        if (playerCardAfterMove instanceof JailCard) {
                            JailCard playerCardAfterMove1 = (JailCard) playerCardAfterMove;
                            if (playerCardAfterMove1.getType() != 0) {
                                player.setInJail(true);
                                player.setCurrCardIndex(JailCard.jailCardInd);
                            }
                        } else if (playerCardAfterMove instanceof JackpotCard) {
                            System.out.println(GREEN_BOLD_BRIGHT + "\n\uD83D\uDC73Богатый Дядюшка: " + ANSI_RESET + "Ничего себе! Тебе повезло, ты попал на поле \uD83D\uDC51Джекпот\uD83D\uDC51. Давай проверим твою удачу!");
                            System.out.println(BLACK_BOLD + WHITE_BACKGROUND + "\uD83D\uDC8EНажмите любую кнопку, чтобы крутить барабан." + ANSI_RESET);
                            scnLine.nextLine();
                            JackpotCard playerCardAfterMove1 = (JackpotCard) playerCardAfterMove;
                            JackpotCard.getJackpot(player);
                            System.out.println(GREEN_BOLD_BRIGHT + "\n\uD83D\uDC73Богатый Дядюшка: " + ANSI_RESET + getJackpotSymbols());
                            System.out.println(BLACK_BOLD + WHITE_BACKGROUND + "Твой выигрыш: $" + JackpotCard.getJackpot() + "k. Твой баланс: $" + player.getCash() + "k." + ANSI_RESET);


                        } else if (playerCardAfterMove instanceof TravelCard) {
                            TravelCard playerCardAfterMove1 = (TravelCard) playerCardAfterMove;
                            TravelCard.goTravel(player);
                        } else if (playerCardAfterMove instanceof CompanyCard) {
                            CompanyCard playerCardAfterMove1 = (CompanyCard) playerCardAfterMove;
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
                                Scanner scn = new Scanner(System.in);
                                System.out.println(GREEN_BOLD_BRIGHT + "\n\uD83D\uDC73Богатый Дядюшка: " + ANSI_RESET + "Хей! У тебя есть: $" + player.getCash() + "k. Желаешь ли ты приобрести " + playerCardAfterMove1.getName() + " по цене: $" + playerCardAfterMove1.getPrice() + "k?");
                                System.out.println(BLACK_BOLD + WHITE_BACKGROUND + "Введите ваш ответ (Y - для покупки, N - для отказа):" + ANSI_RESET);
                                String playerChoice = scn.next();
                                if (playerChoice.equals("Y") || playerChoice.equals("y")) {
                                    int price = playerCardAfterMove1.getPrice();
                                    if (player.getCash() < price) {
                                        System.out.println(GREEN_BOLD_BRIGHT + "\n\uD83D\uDC73Богатый Дядюшка: " + ANSI_RESET + "О нет! К сожалению, у тебя недостаточно средств. У меня есть пару советов, как заработать, я думаю они тебе помогут.");
                                        System.out.println(BLACK_BOLD + WHITE_BACKGROUND + "У вас недостаточно средств для покупки." + ANSI_RESET);

                                    } else {
                                        player.setCash(player.getCash() - price);
                                        playerCardAfterMove1.setOwner(player);
                                        player.getOwnedCompanies().add(playerCardAfterMove1);
                                        System.out.println(GREEN_BOLD_BRIGHT + "\n\uD83D\uDC73Богатый Дядюшка: " + ANSI_RESET + "Поздравляю тебя с приобретением " + playerCardAfterMove1.getName() + ". Я думаю ты обязательно окупишься!");
                                        System.out.println(BLACK_BOLD + WHITE_BACKGROUND + "Игрок " + player.getName() + " приобрёл компанию " + playerCardAfterMove1.getName() + "." + ANSI_RESET);
                                    }
                                }
                                if(playerChoice.equals("N") || playerChoice.equals("n")){
                                    System.out.println(BLACK_BOLD + WHITE_BACKGROUND + "Вы успешно отказались от покупки компании " + playerCardAfterMove1.getName() + "." + ANSI_RESET);

                                }



                            }
                        }
                        numberOfMove++;
                        statuses.add(new GameMoveStatus(new Date(), numberOfMove, players));

                        System.out.println();
                        System.out.println();
                        break;

                    case 2:
                        System.out.println(GREEN_BOLD_BRIGHT + "\n\uD83D\uDC73Богатый Дядюшка: " + ANSI_RESET + "И снова ты, " + player.getName() + ", сейчас глянем что там у тебя по деньгам.");
                        System.out.println(BLACK_BOLD + WHITE_BACKGROUND + "Ваш баланс: $" + player.getCash() + "k." + ANSI_RESET);
                        System.out.println();
                        System.out.println(BLACK_BOLD + WHITE_BACKGROUND + "Для возврата в меню нажмите любую кнопку." + ANSI_RESET);
                        scnLine.nextLine();
                        break;


                    case 3:
                        if(numberOfMove < 2){
                            System.out.println(BLACK_BOLD + WHITE_BACKGROUND + "История ходов пока неизвестна! Попробуйте позже." + ANSI_RESET);
                            System.out.println();
                            break;
                        }
                        int currNumOf = numberOfMove-1;
                        System.out.println(GREEN_BOLD_BRIGHT + "\n\uD83D\uDC73Богатый Дядюшка: " + ANSI_RESET + "О каком ходе хочешь получить информацию?");
                        System.out.println(BLACK_BOLD + WHITE_BACKGROUND + "Введите номер хода от 1 до " + currNumOf + "." + "Текущий номер хода: "+ numberOfMove + ANSI_RESET);
                        int searchNumOfMove = scanner.nextInt();
                        GameMoveStatus.getStatusAboutMove(statuses, searchNumOfMove);
                        break;

                    case 4:
                        Board.renderBoard();
                        System.out.println();
                        System.out.println();
                        System.out.println(BLACK_BOLD + WHITE_BACKGROUND + "Для возврата в меню нажмите любую кнопку." + ANSI_RESET);
                        scnLine.nextLine();
                        System.out.println();
                        break;

                    default:
                        return;
                }
            }
        }

    }


    public boolean gameCoutined(List<Player> players) {
        Iterator<Player> iterPlayers = players.iterator();
        while (iterPlayers.hasNext()) {
            Player player = iterPlayers.next();
            if (player.getCash() < 0) {
                if (player.getOwnedCompanies().size() > 0) {
                    System.out.println(GREEN_BOLD_BRIGHT + "\n\uD83D\uDC73Богатый Дядюшка: " + ANSI_RESET + "О нет! Кажется игрок " + player.getName() + " в долгах! Мне придётся отобрать принадлежащие тебе компании и продать их.");
                    List<CompanyCard> playersOwnedCompanies = player.getOwnedCompanies();
//                    Collections.sort(playersOwnedCompanies);
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
            Player winner = players.get(0);
            System.out.println(GREEN_BOLD_BRIGHT + "\n\uD83D\uDC73Богатый Дядюшка: " + ANSI_RESET + "УРАААА! Игрок под ником " + winner.getName() + " становится победителем! Мои поздравления! Я до конца верил в тебя, " + winner.getName());
            return false;
        } else {
            return true;
        }
    }

    public boolean nameIsOccupied(List<Player> players, String name) {
        for (Player p : players) {
            if (p.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void generateMap() {
        cardsOfMap.add(new Card("START", 0));
        cardsOfMap.add(new CompanyCard("Chanel", 1, 600, 20));
        cardsOfMap.add(new ChanceCard(2));
        cardsOfMap.add(new CompanyCard("Hugo Boss", 3, 600, 40));
        cardsOfMap.add(new ChargeCard(4));
        cardsOfMap.add(new CompanyCard("Mersedes", 5, 2000, 250));
        cardsOfMap.add(new CompanyCard("Adidas", 6, 1000, 60));
        cardsOfMap.add(new ChanceCard(7));
        cardsOfMap.add(new CompanyCard("Puma", 8, 1000, 60));
        cardsOfMap.add(new CompanyCard("Lacoste", 9, 1200, 80));
        cardsOfMap.add(new TravelCard(10));
        cardsOfMap.add(new CompanyCard("VK", 11, 1400, 100));
        cardsOfMap.add(new CompanyCard("Rockstar Games", 12, 1500, (dice1.getDiceResult() + dice2.getDiceResult()) * 100));
        cardsOfMap.add(new CompanyCard("Facebook", 13, 1400, 100));
        cardsOfMap.add(new CompanyCard("Twitter", 14, 1600, 120));
        cardsOfMap.add(new CompanyCard("Audi", 15, 2000, 250));
        cardsOfMap.add(new CompanyCard("Coca Cola", 16, 1800, 140));
        cardsOfMap.add(new ChanceCard(17));
        cardsOfMap.add(new CompanyCard("Pepsi", 18, 1800, 140));
        cardsOfMap.add(new CompanyCard("Fanta", 19, 2000, 160));
        cardsOfMap.add(new JackpotCard(20));
        cardsOfMap.add(new CompanyCard("American Airlines", 21, 2200, 180));
        cardsOfMap.add(new ChanceCard(22));
        cardsOfMap.add(new CompanyCard("Lufthansa", 23, 2200, 180));
        cardsOfMap.add(new CompanyCard("British Airways", 24, 2400, 200));
        cardsOfMap.add(new CompanyCard("Ford", 25, 2000, 250));
        cardsOfMap.add(new CompanyCard("McDonalds", 26, 2600, 220));
        cardsOfMap.add(new CompanyCard("Burger King", 27, 2600, 220));
        cardsOfMap.add(new CompanyCard("Rovio Games", 28, 1500, (dice1.getDiceResult() + dice2.getDiceResult()) * 100));
        cardsOfMap.add(new CompanyCard("KFC", 29, 2800, 240));
        cardsOfMap.add(new JailCard(30, 0));
        cardsOfMap.add(new CompanyCard("Holiday Inn", 31, 3000, 260));
        cardsOfMap.add(new CompanyCard("Radisson", 32, 3000, 260));
        cardsOfMap.add(new ChanceCard(33));
        cardsOfMap.add(new CompanyCard("Novotel", 34, 3200, 280));
        cardsOfMap.add(new CompanyCard("Land Rover", 35, 2000, 250));
        cardsOfMap.add(new ChargeCard(36));
        cardsOfMap.add(new CompanyCard("Apple", 37, 3500, 350));
        cardsOfMap.add(new ChanceCard(38));
        cardsOfMap.add(new CompanyCard("Nokia", 39, 4000, 500));
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




