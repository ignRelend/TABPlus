package me.relend.tabplus;

import me.relend.tabplus.commands.*;
import me.relend.tabplus.listeners.*;
import me.relend.tabplus.util.Util;
import org.bukkit.plugin.java.JavaPlugin;

public class TABPlus extends JavaPlugin {

    @Override
    public void onEnable() {
        if (getServer().getPluginManager().getPlugin("PlaceholderAPI") != null) {
            registerConfig();
            registerCommands();
            registerListeners();
            Util.PLACEHOLDERAPI = true;
        } else {
            getLogger().warning("PlaceholderAPI not found. You cannot use placeholders!");
            registerConfig();
            registerCommands();
            registerListeners();
        }
    }

    private void registerListeners() {
        getServer().getPluginManager().registerEvents(new JoinListener(), this);
        getServer().getPluginManager().registerEvents(new WorldChangeListener(), this);
    }

    private void registerCommands() {
        getCommand("tab").setExecutor(new TABCommand(this));
        getCommand("tab").setTabCompleter(new TABCompleter());
    }

    private void registerConfig() {
        getConfig().options().copyDefaults();
        this.saveDefaultConfig();
    }

}
