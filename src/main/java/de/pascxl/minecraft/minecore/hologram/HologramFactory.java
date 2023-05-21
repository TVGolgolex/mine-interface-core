package de.pascxl.minecraft.minecore.hologram;

import org.bukkit.Location;

public interface HologramFactory {

  Hologram createHologram(Location location, String hologramName);

}
