package dev.lightdream.starwarsabilities;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class Utils {

    public static void throwEntity(Entity ent, Player player)
    {
        Vector vector = player.getLocation().getDirection();
        int pitch = (int)player.getLocation().getPitch();
        vector.setY(0.4D);
        if (pitch == 0) {
            vector.setZ(vector.getZ() + 1.5D);
        }
        if (pitch == 1) {
            vector.setX(vector.getX() - 1.5D);
        }
        if (pitch == 2) {
            vector.setZ(vector.getZ() - 1.5D);
        }
        if (pitch == 3) {
            vector.setX(vector.getX() + 1.5D);
        }
        ent.setVelocity(vector);
    }

    public static double distance(Location l1, Location l2){
        return Math.sqrt(Math.pow(l1.getX() - l2.getX(), 2) + Math.pow(l1.getY() - l2.getY(), 2) + Math.pow(l1.getZ() - l2.getZ(), 2));
    }

}
