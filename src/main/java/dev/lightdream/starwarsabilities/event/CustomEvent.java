package dev.lightdream.starwarsabilities.event;

import org.bukkit.Bukkit;
import org.bukkit.event.Event;

public abstract class CustomEvent extends Event {

    private boolean canceled;

    public boolean isCanceled() {
        return canceled;
    }

    public void setCanceled(boolean canceled) {
        this.canceled = canceled;
    }

    public void fire() {
        Bukkit.getPluginManager().callEvent(this);
    }

}
