package de.pascxl.minecraft.minecore.stats.floating;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;

@Getter
@AllArgsConstructor
public class StatsTemplate {

    private String gameMode;

    private ItemStack gameIdentifier;

    private boolean timedStats;

    private String[] displayKeys;

    public String getName() {
        return ChatColor.stripColor(this.gameMode).replace(" ", "_").toLowerCase();
    }
}
