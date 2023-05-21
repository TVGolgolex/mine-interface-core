package de.pascxl.minecraft.minecore.stats.lobby;

import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import de.pascxl.minecraft.minecore.stats.stats.IStats;
import de.pascxl.minecraft.minecore.MineCore;
import de.pascxl.minecraft.minecore.stats.ranking.ITopTenRanking;
import de.pascxl.minecraft.minecore.stats.utils.StatsTime;
import de.pascxl.minecraft.minecore.thread.MoreExecutors;

import java.util.ArrayList;
import java.util.List;

public class LobbyTopTenRanking implements ITopTenRanking {

    private LobbyGameMode lobbyGameMode;

    public LobbyTopTenRanking(LobbyGameMode lobbyGameMode) {
        this.lobbyGameMode = lobbyGameMode;
    }

    @Override
    public ListenableFuture<List<IStats>> getTopTen(StatsTime statsTime) {
        return Futures.transform(this.lobbyGameMode.getRankingRepository().getTopTen(statsTime), list -> {
            List<IStats> stats = new ArrayList<>();
            if (list != null) {
                list.forEach(uuid -> {
                    if (uuid == null) {
                        return;
                    }
                    stats.add(new LobbyStats(uuid, MineCore.getInstance().getPlayerManager().getGlobalPlayer(uuid).getUsername(), lobbyGameMode));
                });
            }
            return stats;
        }, MoreExecutors.getDirectExecutor());
    }
}
