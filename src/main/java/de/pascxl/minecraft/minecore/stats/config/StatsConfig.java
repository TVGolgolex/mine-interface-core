package de.pascxl.minecraft.minecore.stats.config;

import lombok.Getter;
import de.pascxl.minecraft.minecore.config.Comment;
import de.pascxl.minecraft.minecore.config.Config;
import de.pascxl.minecraft.minecore.config.Path;

import java.io.File;

/**
 * Created by Pascal K. on 17.05.2023.
 */
@Getter
public class StatsConfig extends Config {

    @Path("stats.database")
    private String statsDatabase = "stats";

    @Path("stats.enabled")
    private boolean statsEnabled = true;

    @Path("stats.game_mode")
    private String gameMode = "test";

    @Path("stats.timed_stats_group_hour")
    private int timedStatsGroupHour = 8;

    @Path("stats.max_offline_stats_fetches")
    private int maxOfflineStatsFetches = 10;

    @Comment("Time in minutes")
    @Path("stats.reset-ranking")
    private int resetRankingTime = 60;

    public StatsConfig(File file) {
        CONFIG_FILE = file;
    }
}
