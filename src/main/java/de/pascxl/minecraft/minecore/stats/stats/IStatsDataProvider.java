package de.pascxl.minecraft.minecore.stats.stats;

import de.pascxl.minecraft.minecore.stats.ranking.IRankedStats;
import de.pascxl.minecraft.minecore.stats.ranking.ITopTenRanking;

import java.util.UUID;

public interface IStatsDataProvider {

    IStats getStats( UUID uniqueId );

    IRankedStats getRankedStats(long rank );

    ITopTenRanking getRanking();
}
