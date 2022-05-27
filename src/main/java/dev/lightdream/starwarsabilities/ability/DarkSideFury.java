package dev.lightdream.starwarsabilities.ability;

import dev.lightdream.lambda.ScheduleUtils;
import dev.lightdream.starwarsabilities.Main;
import dev.lightdream.starwarsabilities.api.API;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class DarkSideFury extends Ability {
    public DarkSideFury() {
        super(Main.instance.config.darkSideFuryCooldown);
    }

    @Override
    public void execute(Player player) {
        double hearts = API.getHealth(player);

        ScheduleUtils.runTaskLater(() -> {
            double newHearts = API.getHealth(player);
            if (newHearts > hearts - Main.instance.config.darkSideFuryDamageBoostDamageRequirement) {
                return;
            }
            player.addPotionEffect(new PotionEffect(
                    PotionEffectType.INCREASE_DAMAGE,
                    Main.instance.config.darkSideFuryDamageBoostDuration,
                    Main.instance.config.darkSideFuryDamageBoost
            ));
        }, Main.instance.config.darkSideFuryDamageBoostTimer);
    }
}
