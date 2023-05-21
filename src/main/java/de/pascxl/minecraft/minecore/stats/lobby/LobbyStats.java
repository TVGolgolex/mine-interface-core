package de.pascxl.minecraft.minecore.stats.lobby;

import com.google.common.base.Function;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import de.pascxl.minecraft.minecore.stats.stats.IStats;
import de.pascxl.minecraft.minecore.stats.stats.StatEntry;
import de.pascxl.minecraft.minecore.stats.utils.StatsTime;
import de.pascxl.minecraft.minecore.thread.MoreExecutors;

import java.util.*;
import java.util.concurrent.ExecutionException;

public class LobbyStats implements IStats {

    private UUID uniqueId;

    private String name;

    private ListenableFuture<Map<String, Long>> overallStats;

    private ListenableFuture<Map<String, List<StatEntry>>> timedStats;

    private Map<StatsTime, ListenableFuture<Long>> ranking;

    public LobbyStats(UUID uniqueId, String name, LobbyGameMode lobbyGameMode) {
        this.uniqueId = uniqueId;
        this.name = name;

        this.overallStats = lobbyGameMode.getStatsRepository().getStatsOverall(uniqueId);
        this.timedStats = lobbyGameMode.getStatsRepository().getTimedStats(uniqueId);

        this.ranking = new HashMap<>();
        Arrays.stream(StatsTime.values()).forEach(statsTime -> this.ranking.put(statsTime,
                lobbyGameMode.getRankingRepository().getRank(uniqueId, statsTime)));
    }

    @Override
    public UUID getUniqueId() {
        return this.uniqueId;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public long get(String key, StatsTime statsTime) {
        try {
            return this.getAsync(key, statsTime).get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return 0L;
        }
    }

    @Override
    public ListenableFuture<Long> getAsync(String key, StatsTime statsTime) {
        if (statsTime.equals(StatsTime.ALL_TIME)) {
            return Futures.transform(this.overallStats, stats -> {
                if (stats == null) {
                    return 0L;
                }
                return stats.getOrDefault(key, 0L);
            }, MoreExecutors.getDirectExecutor());
        }
        return Futures.transform(this.timedStats, (Function<Map<String, List<StatEntry>>, Long>) stats -> {
            if (stats == null) {
                return 0L;
            }
            List<StatEntry> statEntries = stats.getOrDefault(key, null);
            if (statEntries == null || statEntries.isEmpty()) {
                return 0L;
            }
            long before = System.currentTimeMillis() - statsTime.getTimeInMillis();
            long amount = 0;

            for (StatEntry entry : statEntries) {
                if (entry == null) continue;
                if (entry.getTimestamp() <= before) {
                    continue;
                }
                amount += entry.getValue();
            }
            return amount;
        }, MoreExecutors.getDirectExecutor());
    }

    @Override
    public ListenableFuture<Void> manipulate(String key, long value) {
        throw new UnsupportedOperationException("Can't manipulate lobby stats! (Name: " + this.name + ")");
    }

    @Override
    public ListenableFuture<Long> getRanking(StatsTime statsTime) {
        return this.ranking.getOrDefault(statsTime, Futures.immediateFuture(-1L));
    }

    @Override
    public void reset() {
        throw new UnsupportedOperationException("Can't reset lobby stats! (Name: " + this.name + ")");
    }
}
