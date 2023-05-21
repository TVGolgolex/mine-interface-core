package de.pascxl.minecraft.minecore.utilities.spigot.position;

import java.util.Map;

/**
 * Created by P. Kurz on 28.02.2023 (user: Pascal).
 */
public interface PositionManager {

    Map<String, PositionProvider> positionProviders();

    PositionProvider provider(String poolName);

    Position convert(double x, double y, double z, float yaw, float pitch, String worldName);

}
