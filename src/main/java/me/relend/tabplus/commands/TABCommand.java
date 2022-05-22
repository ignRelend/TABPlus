package me.relend.tabplus.commands;

import me.clip.placeholderapi.PlaceholderAPI;
import me.relend.tabplus.TABPlus;
import me.relend.tabplus.util.Util;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class TABCommand implements CommandExecutor {

    private final TABPlus plugin;

    public TABCommand(TABPlus plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender.hasPermission("tab.admin") || sender.isOp() || sender instanceof ConsoleCommandSender) {
            if (args.length == 0) {
                sender.sendMessage(Util.color("&c/tab <reload|info>"));
            } else {
                if (args[0] != null) {
                    if (args[0].equalsIgnoreCase("reload")) {
                        try {
                            plugin.reloadConfig();
                            sender.sendMessage(Util.color("&aSuccessfully reloaded TABPlus config!"));
                        } catch (Exception e) {
                            sender.sendMessage(Util.color("&cError reloading TABPlus config!"));
                        }
                        for (Player p : Bukkit.getOnlinePlayers()) {
                            if (Util.PLACEHOLDERAPI) {
                                p.setPlayerListHeader(PlaceholderAPI.setPlaceholders(p, Util.color(Util.getHeader(p.getWorld()))));
                                p.setPlayerListFooter(PlaceholderAPI.setPlaceholders(p, Util.color(Util.getFooter(p.getWorld()))));
                            } else {
                                p.setPlayerListHeader(Util.color(Util.getHeader(p.getWorld())));
                                p.setPlayerListFooter(Util.color(Util.getFooter(p.getWorld())));
                            }
                        }
                    } else if (args[0].equalsIgnoreCase("info")) {
                        sender.sendMessage(Util.color("&2&lTABPlus &a" + Util.VERSION + " &7by &a" + Util.AUTHOR));
                    } else {
                        sender.sendMessage(Util.color("&c/tab <reload|info>"));
                    }
                } else {
                    sender.sendMessage(Util.color("&c/tab <reload|info>"));
                }
            }
        } else {
            sender.sendMessage(Util.color("&cNo permission."));
        }
        return false;
    }
}
