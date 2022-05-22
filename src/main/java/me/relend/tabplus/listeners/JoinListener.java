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
            event.getPlayer().setPlayerListHeader(PlaceholderAPI.setPlaceholders(event.getPlayer(), Util.getHeader()));
            event.getPlayer().setPlayerListFooter(PlaceholderAPI.setPlaceholders(event.getPlayer(), Util.getFooter()));
        } else {
            event.getPlayer().setPlayerListHeader(Util.getHeader());
            event.getPlayer().setPlayerListFooter(Util.getFooter());
        }
    }
}
