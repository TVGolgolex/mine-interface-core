package de.pascxl.minecraft.minecore.utilities.spigot;

import de.pascxl.minecraft.minecore.utilities.Doubled;
import de.pascxl.minecraft.minecore.utilities.spigot.position.Position;
import de.pascxl.minecraft.minecore.utilities.spigot.position.PositionMeta;
import org.bukkit.Location;
import org.bukkit.util.BoundingBox;

import java.util.Collection;

/**
 * Created by P. Kurz on 28.02.2023 (user: Pascal).
 */
public interface LocationUtil {

    String toString(Location location);

    BoundingBox getBoundingBox(Position firstPosition, Position secondPosition);

    BoundingBox getBoundingBox(Location firstLocation, Location secondLocation);

    Doubled<Location, Collection<PositionMeta>> getLocation(Position position);

    Position getPosition(Location location, PositionMeta... positionMetas);

    String[] getMessageString(Location location);

    Location getLocation(String locationString);

    boolean isSame(Location var1, Location var2);

    boolean isSame(Location var1, Position var2);

}
