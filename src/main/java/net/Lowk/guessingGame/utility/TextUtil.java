package net.Lowk.guessingGame.utility;

import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TextUtil {

    public static String colorize(String s) {
        if (s == null) return "";
        return ChatColor.translateAlternateColorCodes('&', s);
    }

    public static List<String> colorize(List<String> s) {
        List<String> newList = new ArrayList<>();
        for (String str : s) {
            newList.add(colorize(str));
        }
        return newList;
    }

    public static String[] colorize(String[] lines) {
        return colorize(Arrays.asList(lines.clone())).toArray(new String[0]);
    }

}
