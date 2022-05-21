package dev.lightdream.starwarsabilities;

import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

/*

Force Throw - Allows Luke to pickup a block (duplicates block ability is right clicked on as a falling block) and hurl it towards his enemies dealing high damage on impact
Rallying Cry - Grants a 10% speed boost to all allies no matter where they are and grants resistance for 8 to any allies in a 10 block radius 10 seconds after the ability is first activated. Rex is highlighted during this ability to all allies.
Darkside Fury - Grants Vader a damange bonus of 20% for 5 seconds if he takes 20 hearts of damage in a 5 second period. 30 second cooldown.
Resurrection - If activated while under 5 hearts, for the duration of five seconds, Sidious will be revived to half heath after dying. Ability is removed for this second life
Grappling Hook - Rapidly pulls Aurra towards the landing point of the grappling hook. Great for vertical movement. When user lands it on a target, they are pulled towards the user.
Jetpack - Activated with double space, holding down space gains altitude, crouch lowers altitude. WASD flight controls. 10 seconds of flight time, 16 seconds to refuel jetpack.
 */
