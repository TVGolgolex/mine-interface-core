package de.pascxl.minecraft.minecore.stats.ranking;

import com.google.common.util.concurrent.ListenableFuture;
import de.pascxl.minecraft.minecore.stats.stats.IStats;
import de.pascxl.minecraft.minecore.stats.utils.StatsTime;

import java.util.List;

public interface ITopTenRanking {
    ListenableFuture<List<IStats>> getTopTen(StatsTime statsTime);
}
