package de.pascxl.minecraft.minecore.stats.config;

import lombok.Data;
import lombok.EqualsAndHashCode;
import de.pascxl.minecraft.minecore.config.Config;
import de.pascxl.minecraft.minecore.config.InvalidConverterException;
import de.pascxl.minecraft.minecore.config.Path;
import org.bukkit.Location;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class StatsLocationConfig extends Config {

    @Path("ranking-wall.locations")
    private List<Location> rankingWallLocations = new ArrayList<>();

    @Path("hologram.location")
    private Location hologramLocation = null;

    public StatsLocationConfig(File file) {
        this.CONFIG_FILE = file;
        try {
            this.addConverter(LocationConverter.class);
        } catch (InvalidConverterException e) {
            e.printStackTrace();
        }
    }
}
