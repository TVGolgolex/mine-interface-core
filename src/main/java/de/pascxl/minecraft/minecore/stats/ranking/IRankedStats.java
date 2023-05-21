package de.pascxl.minecraft.minecore.stats.ranking;

import com.google.common.util.concurrent.ListenableFuture;
import de.pascxl.minecraft.minecore.stats.stats.IStats;
import de.pascxl.minecraft.minecore.stats.utils.StatsTime;

public interface IRankedStats {
    ListenableFuture<IStats> getStats(StatsTime statsTime);
}
