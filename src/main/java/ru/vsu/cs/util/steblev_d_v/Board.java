package ru.vsu.cs.util.steblev_d_v;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;



public class Board {
    public static final String BLACK_BOLD = "\033[1;30m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String GREEN_BOLD = "\033[1;32m";  // GREEN

    public static final String BLACK_BACKGROUND = "\033[40m";  // BLACK
    public static final String WHITE_BOLD = "\033[1;37m";  // WHITE
    public static final String RED_BACKGROUND = "\033[41m";    // RED
    public static final String GREEN_BACKGROUND = "\033[42m";  // GREEN
    public static final String YELLOW_BACKGROUND = "\033[43m"; // YELLOW
    public static final String BLUE_BACKGROUND = "\033[44m";   // BLUE
    public static final String PURPLE_BACKGROUND = "\033[45m"; // PURPLE
    public static final String CYAN_BACKGROUND = "\033[46m";   // CYAN
    public static final String WHITE_BACKGROUND = "\033[47m";  // WHITE

    public static final String BLACK_BACKGROUND_BRIGHT = "\033[0;100m";// BLACK
    public static final String RED_BACKGROUND_BRIGHT = "\033[0;101m";// RED
    public static final String GREEN_BACKGROUND_BRIGHT = "\033[0;102m";// GREEN
    public static final String YELLOW_BACKGROUND_BRIGHT = "\033[0;103m";// YELLOW
    public static final String BLUE_BACKGROUND_BRIGHT = "\033[0;104m";// BLUE
    public static final String PURPLE_BACKGROUND_BRIGHT = "\033[0;105m"; // PURPLE
    public static final String CYAN_BACKGROUND_BRIGHT = "\033[0;106m";  // CYAN
    public static final String WHITE_BACKGROUND_BRIGHT = "\033[0;107m";   // WHITE

    public static List<Integer> lastIndexes = new ArrayList<>();
    public static List<String> deletedELements = new ArrayList<>();

//    static List<String> board = Arrays.asList(YELLOW_BACKGROUND + BLACK_BOLD + " Старт " + ANSI_RESET, "1", "2", "3", "4", "5", "6", "7", "8", "9", YELLOW_BACKGROUND + BLACK_BOLD + "Путешествие" + ANSI_RESET,
//            "11", "12", "13", "14", "15", "16", "17", "18", "19", YELLOW_BACKGROUND + BLACK_BOLD + "  Джекпот  " + ANSI_RESET,
//            "21", "22", "23", "24", "25", "26", "27", "28", "29", YELLOW_BACKGROUND + BLACK_BOLD + "Тюрьма" + ANSI_RESET,
//            "31", "32", "33", "34", "35", "36", "37", "38", "39", "40");


    static List<String> board = Arrays.asList(YELLOW_BACKGROUND + BLACK_BOLD + " START\uD83C\uDFC1" + ANSI_RESET, PURPLE_BACKGROUND + BLACK_BOLD + " CHANEL " + ANSI_RESET,
            GREEN_BACKGROUND_BRIGHT + BLACK_BOLD + "  ?  " + ANSI_RESET, PURPLE_BACKGROUND + BLACK_BOLD + "HUGO BOSS" + ANSI_RESET, GREEN_BOLD + BLACK_BACKGROUND + "   \uD83D\uDCB5   " + ANSI_RESET + ANSI_RESET, YELLOW_BACKGROUND + BLACK_BOLD
                    + "MERSEDES" + ANSI_RESET, YELLOW_BACKGROUND_BRIGHT + BLACK_BOLD + "ADIDAS" + ANSI_RESET,
            GREEN_BACKGROUND_BRIGHT + BLACK_BOLD + "  ?  " + ANSI_RESET, YELLOW_BACKGROUND_BRIGHT + BLACK_BOLD + "PUMA" + ANSI_RESET, YELLOW_BACKGROUND_BRIGHT + BLACK_BOLD + "LACOSTE" + ANSI_RESET,
            YELLOW_BACKGROUND + BLACK_BOLD + " TRAVEL\uD83D\uDE97 " + ANSI_RESET,
            BLUE_BACKGROUND_BRIGHT + BLACK_BOLD + "   VK   " + ANSI_RESET, RED_BACKGROUND_BRIGHT + BLACK_BOLD + "ROCKSTAR" + ANSI_RESET, BLUE_BACKGROUND_BRIGHT + BLACK_BOLD + "FACEBOOK" + ANSI_RESET, BLUE_BACKGROUND_BRIGHT + BLACK_BOLD + "TWITTER " + ANSI_RESET,
            YELLOW_BACKGROUND + BLACK_BOLD + "  AUDI  " + ANSI_RESET, CYAN_BACKGROUND + BLACK_BOLD + " COLA   " + ANSI_RESET, GREEN_BACKGROUND_BRIGHT + BLACK_BOLD + "   ?    " + ANSI_RESET,
            CYAN_BACKGROUND + BLACK_BOLD + " PEPSI  " + ANSI_RESET, CYAN_BACKGROUND + BLACK_BOLD + " FANTA  " + ANSI_RESET,
            YELLOW_BACKGROUND + BLACK_BOLD + " JACKPOT\uD83C\uDFB0 " + ANSI_RESET,
            GREEN_BACKGROUND + BLACK_BOLD + "AIRLINES" + ANSI_RESET, GREEN_BACKGROUND_BRIGHT + BLACK_BOLD + "  ?  " + ANSI_RESET,  GREEN_BACKGROUND + BLACK_BOLD + "LUFTHANSA" + ANSI_RESET,
            GREEN_BACKGROUND + BLACK_BOLD + "AIRWAYS" + ANSI_RESET, YELLOW_BACKGROUND + BLACK_BOLD + "FORD" + ANSI_RESET, YELLOW_BACKGROUND_BRIGHT + BLACK_BOLD + "MCDON" + ANSI_RESET,
            YELLOW_BACKGROUND_BRIGHT + BLACK_BOLD + "  BURGER  " + ANSI_RESET, RED_BACKGROUND_BRIGHT + BLACK_BOLD + "ROVIO" + ANSI_RESET, YELLOW_BACKGROUND_BRIGHT + BLACK_BOLD + "  KFC  " + ANSI_RESET, YELLOW_BACKGROUND + BLACK_BOLD + " JAIL\uD83D\uDC6E " + ANSI_RESET,
            PURPLE_BACKGROUND_BRIGHT + BLACK_BOLD + "   INN  " + ANSI_RESET, PURPLE_BACKGROUND_BRIGHT + BLACK_BOLD + "RADISSON" + ANSI_RESET, GREEN_BACKGROUND_BRIGHT + BLACK_BOLD + "   ?    " + ANSI_RESET,
            PURPLE_BACKGROUND_BRIGHT + BLACK_BOLD + "NOVOTEL " + ANSI_RESET, YELLOW_BACKGROUND + BLACK_BOLD + "  ROVER " + ANSI_RESET, GREEN_BOLD + BLACK_BACKGROUND + "   \uD83D\uDCB5   " + ANSI_RESET  + ANSI_RESET, WHITE_BACKGROUND + BLACK_BOLD + "  APPLE " + ANSI_RESET, GREEN_BACKGROUND_BRIGHT + BLACK_BOLD + "    ?   " + ANSI_RESET,
            WHITE_BACKGROUND + BLACK_BOLD + " NOKIA  " + ANSI_RESET, "40");
    public static void renderBoard() {

        for (int k = 0; k < 11; k++) {
            if (k == 10) {
                System.out.print(board.get(10));
                break;
            }
            System.out.print( board.get(k) + " ");
        }
        System.out.println();
        for (int k = 11; k < 20; k++) {
            System.out.print(board.get(k + 20));
            System.out.println("                                                                         " + board.get(k));
        }
        for (int g = board.size() - 11; g >= 20; g--) {
            System.out.print(board.get(g) + " ");


        }
    }


    public static void writePlayersMapping(List<Player> players) {


        if(GameLogic.numberOfMove == 1){
            for (int i = 0; i < players.size(); i++) {
                lastIndexes.add(0);
                deletedELements.add(board.get(players.get(i).getCurrCardIndex()));

            }
        }

        for (int i = 0; i < players.size(); i++) {
                    board.set(lastIndexes.get(i), deletedELements.get(i));
                    lastIndexes.set(i, players.get(i).getCurrCardIndex());
                    deletedELements.set(i, board.get(players.get(i).getCurrCardIndex()));
                    System.out.println(deletedELements.get(i));
                    board.set(players.get(i).getCurrCardIndex(), WHITE_BOLD + players.get(i).getName() + ANSI_RESET);


        }

    }

}






