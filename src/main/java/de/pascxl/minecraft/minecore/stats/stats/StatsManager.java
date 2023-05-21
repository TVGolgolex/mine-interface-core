package de.pascxl.minecraft.minecore.stats.stats;

import com.google.common.util.concurrent.ListenableFuture;
import de.pascxl.minecraft.minecore.stats.gamemode.StatGameMode;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Pascal K. on 17.05.2023.
 */
public interface StatsManager {

    StatGameMode getStatGameMode();

    int getTimedStatsGroupHour();

    ListenableFuture<Map<String, Long>> getStatsOverall(UUID uniqueId);

    ListenableFuture<Map<String, List<StatEntry>>> getTimedStats(UUID uniqueId);

    ListenableFuture<Void> manipulate(UUID uniqueId, String key, long value);

    void resetStats(UUID uniqueId);

}
