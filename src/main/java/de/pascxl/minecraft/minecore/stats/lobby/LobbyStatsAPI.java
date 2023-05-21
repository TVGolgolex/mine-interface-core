package de.pascxl.minecraft.minecore.stats.lobby;

import com.google.common.util.concurrent.ListenableFuture;
import de.pascxl.minecraft.minecore.stats.lobby.config.StatsLobbyConfig;
import de.pascxl.minecraft.minecore.stats.floating.StatsTemplate;
import de.pascxl.minecraft.minecore.stats.gamemode.StatsGameModeManager;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Created by Pascal K. on 18.05.2023.
 */
public interface LobbyStatsAPI {

    StatsLobbyConfig getLobbyConfig();

    StatsGameModeManager getGameModeManager();

    List<LobbyGameMode> gameModes();

    ListenableFuture<LobbyPlayerStats> getPlayerStats(Player player);

    Optional<LobbyGameMode> getGameMode(String name);

    void initFloatingStats(Map<String, StatsTemplate> statsTemplateMap);

    ListenableFuture<Void> loadGameModes();

}
