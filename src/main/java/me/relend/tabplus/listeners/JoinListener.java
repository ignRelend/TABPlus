package me.relend.tabplus.listeners;

import me.clip.placeholderapi.PlaceholderAPI;
import me.relend.tabplus.util.Util;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        if (Util.PLACEHOLDERAPI) {
            event.getPlayer().setPlayerListHeader(PlaceholderAPI.setPlaceholders(event.getPlayer(), Util.color(Util.getHeader(event.getPlayer().getWorld()))));
            event.getPlayer().setPlayerListFooter(PlaceholderAPI.setPlaceholders(event.getPlayer(), Util.color(Util.getFooter(event.getPlayer().getWorld()))));
        } else {
            event.getPlayer().setPlayerListHeader(Util.color(Util.getHeader(event.getPlayer().getWorld())));
            event.getPlayer().setPlayerListFooter(Util.color(Util.getFooter(event.getPlayer().getWorld())));
        }
    }
}
