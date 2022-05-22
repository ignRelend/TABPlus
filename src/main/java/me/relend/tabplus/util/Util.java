package me.relend.tabplus.util;

import me.relend.tabplus.TABPlus;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;

public class Util {

    public static final String VERSION = "v1.1.0";
    public static final String AUTHOR = "Relend";
    public static boolean PLACEHOLDERAPI = false;

    private static final TABPlus plugin = JavaPlugin.getPlugin(TABPlus.class);
    public static String color(String color) {
        return ChatColor.translateAlternateColorCodes('&', color);
    }

    public static String getHeader(World world) {
        if (plugin.getConfig().getConfigurationSection("worlds").contains(world.getName())) {
            StringBuilder header = new StringBuilder();
            for (int i = 0; i < plugin.getConfig().getStringList("worlds." + world.getName() + ".header").size(); i++) {
                if (i != plugin.getConfig().getStringList("worlds." + world.getName() + ".header").size() - 1) {
                    header.append(plugin.getConfig().getStringList("worlds." + world.getName() + ".header").get(i)).append("\n");
                } else {
                    header.append(plugin.getConfig().getStringList("worlds." + world.getName() + ".header").get(i));
                }
            }
            return header.toString();
        } else {
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
    }

    public static String getFooter(World world) {
        if (plugin.getConfig().getConfigurationSection("worlds").contains(world.getName())) {
            StringBuilder footer = new StringBuilder();
            for (int i = 0; i < plugin.getConfig().getStringList("worlds." + world.getName() + ".footer").size(); i++) {
                if (i != plugin.getConfig().getStringList("worlds." + world.getName() + ".footer").size() - 1) {
                    footer.append(plugin.getConfig().getStringList("worlds." + world.getName() + ".footer").get(i)).append("\n");
                } else {
                    footer.append(plugin.getConfig().getStringList("worlds." + world.getName() + ".footer").get(i));
                }
            }
            return footer.toString();
        } else {
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
}
