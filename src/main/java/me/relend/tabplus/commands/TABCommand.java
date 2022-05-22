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
                        plugin.reloadConfig();
                        sender.sendMessage(Util.color("&aSuccessfully reloaded TABPlus config!"));
                        if (sender instanceof Player player) {
                            player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1f, 1f);
                        }
                        for (Player p : Bukkit.getOnlinePlayers()) {
                            p.setPlayerListHeader(PlaceholderAPI.setPlaceholders(p, Util.color(Util.getHeader())));
                            p.setPlayerListFooter(PlaceholderAPI.setPlaceholders(p, Util.color(Util.getFooter())));
                        }
                    } else if (args[0].equalsIgnoreCase("info")) {
                        sender.sendMessage(Util.color("plugin created by relend"));
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
