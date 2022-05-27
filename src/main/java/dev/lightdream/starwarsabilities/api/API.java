package dev.lightdream.starwarsabilities.api;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class API {

    public static List<Player> getAllies(Player player){
        return new ArrayList<>();
    }

    public static double getHealth(Player player){
        return player.getHealth();
    }

    public static void setHealth(Player player, int health){
        player.setHealth(health);
    }

}
