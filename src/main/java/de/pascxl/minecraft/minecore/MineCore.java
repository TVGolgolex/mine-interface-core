package de.pascxl.minecraft.minecore;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import de.pascxl.minecraft.minecore.brand.BrandManager;
import de.pascxl.minecraft.minecore.config.configs.ServerConfig;
import de.pascxl.minecraft.minecore.database.DatabaseManager;
import de.pascxl.minecraft.minecore.hologram.HologramManager;
import de.pascxl.minecraft.minecore.nick.NickAPI;
import de.pascxl.minecraft.minecore.player.PlayerManager;
import de.pascxl.minecraft.minecore.server.ServerManager;
import de.pascxl.minecraft.minecore.stats.StatsAPI;
import de.pascxl.minecraft.minecore.thread.ProcessQueue;
import lombok.Getter;
import de.pascxl.minecraft.minecore.bootstrap.IBootstrap;
import de.pascxl.minecraft.minecore.language.LanguageManager;
import de.pascxl.minecraft.minecore.permission.PermissionManager;
import de.pascxl.minecraft.minecore.utilities.Utilities;

/**
 * Created by Pascal K. on 17.05.2023.
 */
@Getter
public abstract class MineCore {

    @Getter
    private static MineCore instance;
    public static final String CORE_PREFIX = "§8▍ §6ServerCore §8▎ §7";

    protected final long startTime = System.currentTimeMillis();
    protected final IBootstrap<?, ?, ?> bootstrap;
    protected final MongoDatabase mongoDatabase;
    protected final DatabaseManager databaseManager;
    protected final LanguageManager languageManager;
    protected final BrandManager brandManager;
    protected final PermissionManager permissionManager;
    protected final ProcessQueue processQueue;
    protected final PlayerManager playerManager;
    protected final ServerManager serverManager;
    protected final Utilities utilities;
    protected final ServerConfig serverConfig;
    protected final HologramManager hologramManager;
    protected final StatsAPI statsAPI;
    protected final NickAPI nickAPI;

    protected MineCore(IBootstrap<?, ?, ?> bootstrap,
                       MongoDatabase mongoDatabase,
                       DatabaseManager databaseManager,
                       LanguageManager languageManager,
                       BrandManager brandManager,
                       PermissionManager permissionManager,
                       ProcessQueue processQueue,
                       PlayerManager playerManager,
                       ServerManager serverManager,
                       Utilities utilities,
                       ServerConfig serverConfig,
                       HologramManager hologramManager,
                       StatsAPI statsAPI,
                       NickAPI nickAPI) {
        instance = this;
        this.bootstrap = bootstrap;
        this.mongoDatabase = mongoDatabase;
        this.databaseManager = databaseManager;
        this.languageManager = languageManager;
        this.brandManager = brandManager;
        this.permissionManager = permissionManager;
        this.processQueue = processQueue;
        this.playerManager = playerManager;
        this.serverManager = serverManager;
        this.utilities = utilities;
        this.serverConfig = serverConfig;
        this.hologramManager = hologramManager;
        this.statsAPI = statsAPI;
        this.nickAPI = nickAPI;
    }

    public void shutdown() {
        for (MongoClient value : this.databaseManager.getMongoDatabase().getConnections().values()) {
            value.close();
        }
        this.databaseManager.getRedisDatabase().getJedis().disconnect();
        this.bootstrap.terminate();
    }

    public <T> T getPlugin() {
        return (T) this.bootstrap.getPluginInstance();
    }

}
