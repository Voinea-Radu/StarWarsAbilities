package dev.lightdream.starwarsabilities;

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

}
