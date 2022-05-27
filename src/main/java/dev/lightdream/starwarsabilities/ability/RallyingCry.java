package dev.lightdream.starwarsabilities.ability;

import dev.lightdream.lambda.ScheduleUtils;
import dev.lightdream.starwarsabilities.Main;
import dev.lightdream.starwarsabilities.Utils;
import dev.lightdream.starwarsabilities.api.API;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class RallyingCry extends Ability {
    public RallyingCry() {
        super(Main.instance.config.rallyingCryCooldown);
    }

    @Override
    public void execute(Player player) {
        API.getAllies(player).forEach(ally -> {
            ally.addPotionEffect(new PotionEffect(
                    PotionEffectType.SPEED,
                    Main.instance.config.rallyingCrySpeedDuration,
                    Main.instance.config.rallyingCrySpeed
            ));

            double distance = Utils.distance(ally.getLocation(), player.getLocation());

            if (distance > Main.instance.config.rallyingCryResistanceDistance) {
                return;
            }

            ScheduleUtils.runTaskLater(() ->
                    ally.addPotionEffect(new PotionEffect(
                            PotionEffectType.DAMAGE_RESISTANCE,
                            Main.instance.config.rallyingCryResistanceDuration,
                            Main.instance.config.rallyingCryResistance
                    )), Main.instance.config.rallyingCryResistanceTimer);
        });
    }
}
