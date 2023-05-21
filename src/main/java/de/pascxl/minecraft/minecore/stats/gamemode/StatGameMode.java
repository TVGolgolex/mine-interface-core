package de.pascxl.minecraft.minecore.stats.gamemode;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class StatGameMode {

    private String name;

    private String rankingKey, secondaryKey;

    private boolean timedStats;

    private List<String> statKeys;
}
