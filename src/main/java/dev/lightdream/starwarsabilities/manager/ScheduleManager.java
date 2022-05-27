package dev.lightdream.starwarsabilities.manager;

import dev.lightdream.lambda.ScheduleUtils;
import dev.lightdream.logger.Debugger;
import dev.lightdream.starwarsabilities.Utils;
import dev.lightdream.starwarsabilities.event.ForceBlockCollideEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Player;

import java.util.*;

public class ScheduleManager {

    private final HashMap<FallingBlock, UUID> fallingBlockList = new HashMap<>();

    public ScheduleManager() {
        registerBlockCollide();
    }

    public void registerFallingBlock(FallingBlock fallingBlock, Player player) {
        fallingBlockList.put(fallingBlock, player.getUniqueId());
    }

    public void registerBlockCollide() {
        ScheduleUtils.runTaskTimer(() -> {
            List<FallingBlock> remove = new ArrayList<>();
            for (FallingBlock fallingBlock : fallingBlockList.keySet()) {
                if (fallingBlock.isDead()) {
                    remove.add(fallingBlock);
                    continue;
                }

                for (Player player : Bukkit.getOnlinePlayers()) {
                    double distance = Utils.distance(fallingBlock.getLocation(), player.getLocation());

                    if (distance <= 2) {
                        Debugger.log("Collide");
                        remove.add(fallingBlock);
                        ForceBlockCollideEvent event = new ForceBlockCollideEvent(player, Bukkit.getPlayer(fallingBlockList.get(fallingBlock)));
                        event.fire();
                        break;
                    }
                }
            }
            remove.forEach(fallingBlockList::remove);
        }, 0, 50);

    }


}
