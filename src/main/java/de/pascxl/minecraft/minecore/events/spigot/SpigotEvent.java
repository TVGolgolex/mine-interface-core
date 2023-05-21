package de.pascxl.minecraft.minecore.events.spigot;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class SpigotEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    public @NotNull HandlerList getHandlers() {
        return handlers;
    }

    public SpigotEvent() {
        super(false);
    }

    public static @NotNull HandlerList getHandlerList() {
        return handlers;
    }

}
