package dev.lightdream.starwarsabilities.ability;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public abstract class Ability {

    private final HashMap<UUID, Long> cooldownMap = new HashMap<>();

    private final long cooldown;

    public Ability(long cooldown) {
        this.cooldown = cooldown;
    }

    public final void use(Player player) {
        if (cooldownMap.getOrDefault(player.getUniqueId(), 0L) + cooldown > System.currentTimeMillis()) {
            return;
        }

        execute(player);
        cooldownMap.put(player.getUniqueId(), System.currentTimeMillis());
    }

    public abstract void execute(Player player);

}
