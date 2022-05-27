package dev.lightdream.starwarsabilities.ability;

import dev.lightdream.logger.Debugger;
import dev.lightdream.starwarsabilities.Main;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import java.util.HashMap;
import java.util.HashSet;
import java.util.UUID;

public class ForceThrow extends Ability {
    public HashMap<UUID, Material> pickedUpBlocks = new HashMap<>();

    public ForceThrow() {
        super(Main.instance.config.forceThrowCooldown);
    }

    @Override
    public void execute(Player player) {
        if (pickedUpBlocks.containsKey(player.getUniqueId())) {
            throwBlock(player);
            return;
        }
        pickUpBlock(player);
    }

    public void pickUpBlock(Player player) {
        Debugger.log("Executing ForceThrow#pickUpBlock for " + player.getName());

        Block block = player.getTargetBlock((HashSet<Material>) null, 100);

        Debugger.log(block);
        Debugger.log(block.getType());

        if (block.getType() == Material.AIR) {
            Debugger.log("No block found");
            return;
        }

        pickedUpBlocks.put(player.getUniqueId(), block.getType());

        block.setType(Material.AIR);
    }

    @SuppressWarnings("deprecation")
    public void throwBlock(Player player) {
        Debugger.log("Executing ForceThrow#throwBlock for " + player.getName());

        Location location = player.getLocation();
        location.setX(location.getX() + 1);
        Material material = pickedUpBlocks.get(player.getUniqueId());

        FallingBlock block = location.getWorld().spawnFallingBlock(location, material, (byte) 0);

        Main.instance.scheduleManager.registerFallingBlock(block, player);

        Vector dir = location.getDirection();
        block.setVelocity(dir.multiply(2));

        pickedUpBlocks.remove(player.getUniqueId());
    }
}
