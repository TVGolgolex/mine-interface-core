package de.pascxl.minecraft.minecore.stats.lobby;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;

@Getter
@AllArgsConstructor
public class LobbyPlayerStats {

    private Map<String, LobbyStats> playerStats;

    public LobbyStats getStats(String gameMode) {
        return this.playerStats.getOrDefault(gameMode.toLowerCase(), null);
    }
}
