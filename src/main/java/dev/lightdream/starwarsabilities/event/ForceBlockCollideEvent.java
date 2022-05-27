package dev.lightdream.starwarsabilities.event;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class ForceBlockCollideEvent extends CustomEvent {

    private static final HandlerList HANDLERS = new HandlerList();
    private final Player thrower;
    private final Player target;

    public ForceBlockCollideEvent(Player thrower, Player target) {
        this.thrower = thrower;
        this.target = target;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public Player getThrower() {
        return thrower;
    }

    public Player getTarget() {
        return target;
    }
}