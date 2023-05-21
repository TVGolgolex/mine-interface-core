package de.pascxl.minecraft.minecore.config.configs;

import lombok.Getter;
import de.pascxl.minecraft.minecore.config.Config;
import de.pascxl.minecraft.minecore.config.Path;

import java.io.File;

/**
 * Created by Pascal K. on 17.05.2023.
 */
@Getter
public class ServerConfig extends Config {

    @Path("server.lobbyserver")
    private boolean lobbyServer = false;
    @Path("server.devserver")
    private boolean devServer = false;
    @Path("server.stats")
    private boolean statsEnabled = true;

    public ServerConfig(File file) {
        this.CONFIG_FILE = file;
    }
}
