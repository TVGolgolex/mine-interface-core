package de.pascxl.minecraft.minecore.stats.stats;

import com.google.common.util.concurrent.ListenableFuture;
import de.pascxl.minecraft.minecore.stats.utils.StatsTime;

import java.util.UUID;

public interface IStats extends Cloneable {

    UUID getUniqueId();

    String getName();

    long get(String key, StatsTime statsTime);

    ListenableFuture<Long> getAsync(String key, StatsTime statsTime);

    ListenableFuture<Void> manipulate(String key, long value);

    ListenableFuture<Long> getRanking(StatsTime statsTime);

    void reset() throws Exception;
}
