package me.relend.tabplus.util;

import me.clip.placeholderapi.PlaceholderAPI;
import me.relend.tabplus.TABPlus;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class Util {

    public static final String VERSION = "v1.0.0";
    public static final String AUTHOR = "Relend";
    public static boolean PLACEHOLDERAPI = false;

    private static final TABPlus plugin = JavaPlugin.getPlugin(TABPlus.class);
    public static String color(String color) {
        return ChatColor.translateAlternateColorCodes('&', color);
    }

    public static String getHeader() {
        StringBuilder header = new StringBuilder();
        for (int i = 0; i < plugin.getConfig().getStringList("header").size(); i++) {
            if (i != plugin.getConfig().getStringList("header").size() - 1) {
                header.append(plugin.getConfig().getStringList("header").get(i)).append("\n");
            } else {
                header.append(plugin.getConfig().getStringList("header").get(i));
            }
        }
        return header.toString();
    }

    public static String getFooter() {
        StringBuilder footer = new StringBuilder();
        for (int i = 0; i < plugin.getConfig().getStringList("footer").size(); i++) {
            if (i != plugin.getConfig().getStringList("footer").size() - 1) {
                footer.append(plugin.getConfig().getStringList("footer").get(i)).append("\n");
            } else {
                footer.append(plugin.getConfig().getStringList("footer").get(i));
            }
        }
        return footer.toString();
    }
}
