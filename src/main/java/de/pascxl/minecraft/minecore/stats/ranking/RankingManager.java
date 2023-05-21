package de.pascxl.minecraft.minecore.stats.ranking;

import com.google.common.util.concurrent.ListenableFuture;
import de.pascxl.minecraft.minecore.stats.utils.StatsTime;
import de.pascxl.minecraft.minecore.stats.gamemode.StatGameMode;

import java.util.List;
import java.util.UUID;

/**
 * Created by Pascal K. on 17.05.2023.
 */
public interface RankingManager {

    StatGameMode getStatGameMode();

    ListenableFuture<Long> getRank(UUID uniqueId, StatsTime statsTime);

    ListenableFuture<UUID> getPlayer(long rank, StatsTime statsTime);

    ListenableFuture<List<UUID>> getTopTen(StatsTime statsTime);

    ListenableFuture<List<UUID>> getTopList(long start, long end, StatsTime statsTime);

}
