package dev.lightdream.starwarsabilities.ability;

import dev.lightdream.lambda.ScheduleUtils;
import dev.lightdream.starwarsabilities.Main;
import org.bukkit.entity.Player;

public class JetPack extends Ability {
    public JetPack() {
        super(Main.instance.config.jetPackCooldown);
    }

    @Override
    public void execute(Player player) {
        player.setAllowFlight(true);
        player.setFlying(true);

        ScheduleUtils.runTaskLater(() -> {
            player.setAllowFlight(false);
            player.setFlying(false);
        }, Main.instance.config.jetPackFlyTime);
    }
}
