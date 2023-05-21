package de.pascxl.minecraft.minecore.stats.lobby.config;

import lombok.Getter;
import de.pascxl.minecraft.minecore.config.Comment;
import de.pascxl.minecraft.minecore.config.Config;
import de.pascxl.minecraft.minecore.config.InvalidConverterException;
import de.pascxl.minecraft.minecore.config.Path;
import de.pascxl.minecraft.minecore.stats.config.LocationConverter;
import org.bukkit.Location;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class StatsLobbyConfig extends Config {

    @Path("stats-lobby.game_modes")
    private List<String> gameModes = new ArrayList<>() {{
        this.add("ttt");
        this.add("brawl");
    }};

    @Path("stats-lobby.game_modes_ranking_locations")
    private Map<String, List<Location>> gameModesRankingLocations = new HashMap<>() {{
        this.put("ttt", new ArrayList<>());
        this.put("brawl", new ArrayList<>());
    }};

    @Path("stats-lobby.game_modes_floating_locations")
    private Map<String, Location> gameModesFloatingLocations = new HashMap<>();

    @Path("stats.database")
    private String statsDatabase = "stats";

    @Comment("Time in minutes")
    @Path("stats.reset-ranking")
    private int resetRankingTime = 60;

    public StatsLobbyConfig(File file) {
        this.CONFIG_FILE = file;
        try {
            this.addConverter(LocationConverter.class);
        } catch (InvalidConverterException e) {
            e.printStackTrace();
        }
    }
}
