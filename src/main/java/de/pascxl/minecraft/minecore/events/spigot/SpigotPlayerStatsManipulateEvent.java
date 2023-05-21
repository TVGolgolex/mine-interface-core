package de.pascxl.minecraft.minecore.events.spigot;

import de.pascxl.minecraft.minecore.stats.stats.IStats;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by Pascal K. on 17.05.2023.
 */
@Getter
@AllArgsConstructor
public class SpigotPlayerStatsManipulateEvent extends SpigotEvent {

    private String statKey;

    private long value;

    private IStats oldStats;

    private IStats newStats;

}
