package ru.vsu.cs.util.steblev_d_v;

import ru.vsu.cs.util.steblev_d_v.player.PlayerInterface;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static List<PlayerInterface> deepCopyList(List<PlayerInterface> oldList) {
        List<PlayerInterface> newList = new ArrayList<>();
        newList.addAll(oldList);

        return newList;
    }
}
