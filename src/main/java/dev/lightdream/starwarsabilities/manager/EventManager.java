package dev.lightdream.starwarsabilities.manager;

import dev.lightdream.starwarsabilities.Main;
import dev.lightdream.starwarsabilities.api.API;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class EventManager implements Listener {

    private final List<UUID> resurrectionPlayers = new ArrayList<>();
    private final List<UUID> resurrectedPlayers = new ArrayList<>();

    public EventManager() {
        Main.instance.getServer().getPluginManager().registerEvents(this, Main.instance);
    }

    public void registerResurrectionPlayer(Player player) {
        resurrectionPlayers.add(player.getUniqueId());
    }

    @EventHandler
    public void damage(EntityDamageEvent event) {
        Entity entity = event.getEntity();
        if (!(entity instanceof Player)) {
            return;
        }
        Player player = (Player) entity;

        if (!resurrectionPlayers.contains(player.getUniqueId())) {
            return;
        }

        if (resurrectedPlayers.contains(player.getUniqueId())) {
            resurrectionPlayers.remove(player.getUniqueId());
            resurrectedPlayers.remove(player.getUniqueId());
            return;
        }

        double health = API.getHealth(player);
        if ((health - event.getFinalDamage()) <= 0) {
            event.setCancelled(true);
            API.setHealth(player, Main.instance.config.resurrectionHealthAfterDeath);
            resurrectionPlayers.remove(player.getUniqueId());
            resurrectedPlayers.add(player.getUniqueId());
        }
    }


}
