package ru.vsu.cs.util.steblev_d_v;

public interface GraphicsManagerInterface {
    String BLACK_BOLD = "\033[1;30m";
    String GREEN_BOLD = "\033[1;32m";  // GREEN
    String WHITE_BOLD = "\033[1;37m";  // WHITE
    String BLACK_BACKGROUND = "\033[40m";  // BLACK
    String RED_BACKGROUND = "\033[41m";    // RED
    String GREEN_BACKGROUND = "\033[42m";  // GREEN
    String YELLOW_BACKGROUND = "\033[43m"; // YELLOW
    String BLUE_BACKGROUND = "\033[44m";   // BLUE
    String PURPLE_BACKGROUND = "\033[45m"; // PURPLE
    String CYAN_BACKGROUND = "\033[46m";   // CYAN
    String WHITE_BACKGROUND = "\033[47m";  // WHITE
    String BLACK_BACKGROUND_BRIGHT = "\033[0;100m";// BLACK
    String RED_BACKGROUND_BRIGHT = "\033[0;101m";// RED
    String GREEN_BACKGROUND_BRIGHT = "\033[0;102m";// GREEN
    String YELLOW_BACKGROUND_BRIGHT = "\033[0;103m";// YELLOW
    String BLUE_BACKGROUND_BRIGHT = "\033[0;104m";// BLUE
    String PURPLE_BACKGROUND_BRIGHT = "\033[0;105m"; // PURPLE
    String CYAN_BACKGROUND_BRIGHT = "\033[0;106m";  // CYAN
    String WHITE_BACKGROUND_BRIGHT = "\033[0;107m";   // WHITE
    String ANSI_RESET = "\u001B[0m";

    String text = null;
    String fontColor = null;
    String backgroundColor = null;

    void render();
}
