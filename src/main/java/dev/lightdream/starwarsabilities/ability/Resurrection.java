package dev.lightdream.starwarsabilities.ability;

import dev.lightdream.lambda.ScheduleUtils;
import dev.lightdream.starwarsabilities.Main;
import dev.lightdream.starwarsabilities.Utils;
import dev.lightdream.starwarsabilities.api.API;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Resurrection extends Ability {
    public Resurrection() {
        super(Main.instance.config.resurrectionCooldown);
    }

    @Override
    public void execute(Player player) {
        double health = API.getHealth(player);

        if(health > Main.instance.config.resurrectionMaxHealth) {
            return;
        }

        Main.instance.eventManager.registerResurrectionPlayer(player);
    }
}
