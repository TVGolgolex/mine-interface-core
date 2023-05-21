package de.pascxl.minecraft.minecore.stats.lobby;

import lombok.AllArgsConstructor;
import lombok.Getter;
import de.pascxl.minecraft.minecore.stats.gamemode.StatGameMode;
import de.pascxl.minecraft.minecore.stats.ranking.RankingManager;
import de.pascxl.minecraft.minecore.stats.stats.StatsManager;

@Getter
@AllArgsConstructor
public class LobbyGameMode {

    private StatGameMode gameMode;

    private StatsManager statsRepository;

    private RankingManager rankingRepository;
}
