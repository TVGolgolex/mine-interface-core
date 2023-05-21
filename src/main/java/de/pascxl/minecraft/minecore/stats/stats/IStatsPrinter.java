package de.pascxl.minecraft.minecore.stats.stats;

import de.pascxl.minecraft.minecore.stats.utils.StatsTime;
import org.bukkit.entity.Player;

public interface IStatsPrinter {

    void send(Player player, StatsTime statsTime, IStats stats);
}
