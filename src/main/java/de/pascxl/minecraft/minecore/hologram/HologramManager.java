package de.pascxl.minecraft.minecore.hologram;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.Map;

/**
 * Created by Pascal K. on 17.05.2023.
 */
public interface HologramManager {

    Map<String, Hologram> getHolograms();

    HologramFactory hologramFactory();

    Hologram getHologram(String hologramID);

    Hologram createHologram(Location location, String name);

    void deleteHologram(String hologramID);

    // This could be optimized by mapping holograms to Worlds or even Chunks
    // But for simplicity's sake we will just show a player all holograms
    void initPlayer(Player player);

    List<String> getHologramNames();

}
