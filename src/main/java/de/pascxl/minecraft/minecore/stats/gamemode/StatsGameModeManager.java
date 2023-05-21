package de.pascxl.minecraft.minecore.stats.gamemode;

import com.google.common.util.concurrent.ListenableFuture;

import java.util.List;
import java.util.Optional;

/**
 * Created by Pascal K. on 17.05.2023.
 */
public interface StatsGameModeManager {

    ListenableFuture<Optional<StatGameMode>> getStatsGameMode(String name);

    ListenableFuture<List<StatGameMode>> getStatsGameModes();

    ListenableFuture<Void> insertGameMode(String name, String rankingKey, String secondaryKey, boolean timedStats, List<String> statKeys);

}
