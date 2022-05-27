package dev.lightdream.starwarsabilities.ability;

import dev.lightdream.lambda.ScheduleUtils;
import dev.lightdream.starwarsabilities.Main;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.HashSet;

public class Grappling extends Ability {
    public Grappling() {
        super(Main.instance.config.grapplingCooldown);
    }

    @Override
    public void execute(Player player) {
        grappling(player);

    }


    public void grappling(Player player) {
        Block block = player.getTargetBlock((HashSet<Material>) null, 100);

        if (block == null) {
            return;
        }

        if (block.getType() == Material.AIR) {
            return;
        }

        if (block.getLocation().getY() < player.getLocation().getY()) {
            return;
        }

        World world = player.getWorld();
        Location l1 = player.getLocation();
        Location l2 = player.getLocation();

        l1.setX(l1.getX() + getDifX(player.getLocation().getDirection().getX()));
        l1.setZ(l1.getZ() + getDifZ(player.getLocation().getDirection().getZ()));

        l2.setX(l2.getX() - getDifX(player.getLocation().getDirection().getX()));
        l2.setZ(l2.getZ() - getDifZ(player.getLocation().getDirection().getZ()));


        LivingEntity le1 = (LivingEntity) world.spawnEntity(l1, EntityType.BAT);
        LivingEntity le2 = (LivingEntity) world.spawnEntity(l2, EntityType.BAT);

        LivingEntity holder1 = (LivingEntity) world.spawnEntity(player.getLocation(), EntityType.BAT);
        LivingEntity holder2 = (LivingEntity) world.spawnEntity(player.getLocation(), EntityType.BAT);
        holder1.setAI(false);
        holder2.setAI(false);
        le1.setGliding(true);
        le2.setGliding(true);
        le1.setInvulnerable(true);
        le2.setInvulnerable(true);
        holder1.setInvulnerable(true);
        holder2.setInvulnerable(true);
        le1.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 100000, 1));
        le2.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 100000, 1));
        holder1.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 100000, 1));
        holder2.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 100000, 1));
        le1.setLeashHolder(holder1);
        le2.setLeashHolder(holder2);

        ScheduleUtils.runTaskTimer(() -> {

        }, 0, 1);

        new BukkitRunnable() {
            final double x = (block.getLocation().getX() - player.getLocation().getX() * 1.0f) / 20 * 1.0f;
            final double y = Math.max((block.getLocation().getY() - player.getLocation().getY() * 1.0f) / 20 * 1.0f, 0);
            final double z = (block.getLocation().getZ() - player.getLocation().getZ() * 1.0f) / 20 * 1.0f;

            int it = 0;

            @Override
            public void run() {

                it++;
                le1.teleport(new Location(world, le1.getLocation().getX() + x, le1.getLocation().getY() + y, le1.getLocation().getZ() + z));
                le2.teleport(new Location(world, le2.getLocation().getX() + x, le2.getLocation().getY() + y, le2.getLocation().getZ() + z));

                if (it >= 20 + 1) {
                    player.setVelocity(new Vector(block.getLocation().getX() - player.getLocation().getX() * 1.0f, Math.sqrt(block.getLocation().getY() - player.getLocation().getY() * 1.0f) / 2, block.getLocation().getZ() - player.getLocation().getZ() * 1.0f));
                    le1.setHealth(0);
                    le2.setHealth(0);
                    this.cancel();
                }
            }

        }.runTaskTimer(Main.instance, 0, 1);
    }

    private double getDifX(double angle) {
        angle += 1;
        return Math.cos(180 * angle) * 0.1;
    }

    private double getDifZ(double angle) {
        angle += 1;
        return Math.sin(180 * angle) * 0.1;
    }
}
