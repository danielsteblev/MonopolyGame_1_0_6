package ru.vsu.cs.util.steblev_d_v.graphics;

import ru.vsu.cs.util.steblev_d_v.graphics.GraphicsManagerInterface;

import java.util.ArrayList;

public abstract class GraphicsUtils implements GraphicsManagerInterface {
    public static String convertColorNameToConsole(String color, boolean bright) {
        switch (color) {
            case "black":
                if (bright) {
                    color = BLUE_BACKGROUND_BRIGHT;
                } else color = BLACK_BACKGROUND;
                return color;
            case "green":
                if (bright) {
                    color = GREEN_BACKGROUND_BRIGHT;
                } else color = GREEN_BACKGROUND;
                return color;
            case "white":
                if (bright) {
                    color = WHITE_BACKGROUND_BRIGHT;
                } else color = WHITE_BACKGROUND;
                return color;
            case "red":
                if (bright) {
                    color = RED_BACKGROUND_BRIGHT;
                } else color = RED_BACKGROUND;
                return color;
            case "yellow":
                if (bright) {
                    color = YELLOW_BACKGROUND_BRIGHT;
                } else color = YELLOW_BACKGROUND;
                return color;
            case "purple":
                if (bright) {
                    color = PURPLE_BACKGROUND_BRIGHT;
                } else color = PURPLE_BACKGROUND;
                return color;
            case "cyan":
                if (bright) {
                    color = CYAN_BACKGROUND_BRIGHT;
                } else color = CYAN_BACKGROUND;
                return color;
            case "blue":
                if (bright) {
                    color = BLUE_BACKGROUND_BRIGHT;
                } else color = BLUE_BACKGROUND;
                return color;
        }
        return color;
    }

    public static int getMax(ArrayList<Integer> list) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > max) {
                max = list.get(i);
            }
        }
        return max;
    }

}
