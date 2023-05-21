package de.pascxl.minecraft.minecore.stats.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.concurrent.TimeUnit;

@Getter
@AllArgsConstructor
public enum StatsTime {

    ALL_TIME(-1, "statsall", null),
    MONTHLY(30L, "stats", TimeUnit.DAYS);

    private final long duration;
    private final String commandName;
    private final TimeUnit timeUnit;

    public long getTimeInMillis() {
        if (this.equals(ALL_TIME)) return 0;
        return this.timeUnit.toMillis(this.duration);
    }

    public static StatsTime getHighestStatsTime() {
        return StatsTime.MONTHLY;
    }
}
