package de.pascxl.minecraft.minecore.utilities.spigot.position;

import org.bukkit.Location;

import java.util.Collection;

/**
 * Created by P. Kurz on 28.02.2023 (user: Pascal).
 */
public interface Position {

    double getX();

    double getY();

    double getZ();

    float getYaw();

    float getPitch();

    String getWorldName();

    Collection<PositionMeta> getMetas();

    Location toLocation();

}
