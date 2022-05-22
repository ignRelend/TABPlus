package me.relend.tabplus;

import me.clip.placeholderapi.PlaceholderAPI;
import me.relend.tabplus.commands.*;
import me.relend.tabplus.listeners.*;
import org.bukkit.plugin.java.JavaPlugin;

public class TABPlus extends JavaPlugin {

    @Override
    public void onEnable() {
        if (getServer().getPluginManager().getPlugin("PlaceholderAPI") != null) {
            registerConfig();
            registerCommands();
            registerListeners();
        } else {
            getLogger().warning("PlaceholderAPI not found. You cannot use placeholders!");
            registerConfig();
            registerCommands();
            registerListeners();
        }
    }

    private void registerListeners() {
        getServer().getPluginManager().registerEvents(new JoinListener(), this);
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
