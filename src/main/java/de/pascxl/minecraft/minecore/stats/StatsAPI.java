package de.pascxl.minecraft.minecore.stats;

import com.google.common.util.concurrent.ListenableFuture;
import de.pascxl.minecraft.minecore.stats.config.StatsConfig;
import de.pascxl.minecraft.minecore.stats.gamemode.StatGameMode;
import de.pascxl.minecraft.minecore.stats.gamemode.StatsGameModeManager;
import de.pascxl.minecraft.minecore.stats.lobby.LobbyStatsAPI;
import de.pascxl.minecraft.minecore.stats.ranking.IRankedStats;
import de.pascxl.minecraft.minecore.stats.ranking.ITopTenRanking;
import de.pascxl.minecraft.minecore.stats.ranking.RankingManager;
import de.pascxl.minecraft.minecore.stats.stats.IStats;
import de.pascxl.minecraft.minecore.stats.stats.IStatsDataProvider;
import de.pascxl.minecraft.minecore.stats.stats.IStatsPrinter;
import de.pascxl.minecraft.minecore.stats.stats.StatsManager;
import de.pascxl.minecraft.minecore.stats.utils.StatsTime;
import de.pascxl.minecraft.minecore.MineCore;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Pascal K. on 17.05.2023.
 */
public interface StatsAPI {

    static StatsAPI getInstance() {
        return MineCore.getInstance().getStatsAPI();
    }

    static String STATS_PREFIX() {
        return "§8▍ §6Stats §8▎ §7";
    }

    LobbyStatsAPI getLobbyStatsApi();

    StatsConfig getStatsConfig();

    StatGameMode getGameMode();

    StatsGameModeManager getStatsGameModeManager();

    StatsManager getStatsManager();

    RankingManager getRankingManager();

    IStatsDataProvider getStatsDataProvider();

    IStatsPrinter getStatsPrinter();

    ITopTenRanking getTopTenRanking();

    Map<UUID, IStats> loadedStats();

    Map<Long, IRankedStats> loadedRankedStats();

    void registerDataProvider(IStatsDataProvider provider);

    void registerStatsPrinter(IStatsPrinter printer);

    IStats getStats(UUID uniqueId);

    IRankedStats getRankedStats(long rank);

    ListenableFuture<List<IStats>> getTopTen(StatsTime statsTime);

    void removeFromCache(UUID uniqueId);

}
