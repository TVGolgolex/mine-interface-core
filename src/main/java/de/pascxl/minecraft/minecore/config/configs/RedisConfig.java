package de.pascxl.minecraft.minecore.config.configs;

import lombok.Getter;
import de.pascxl.minecraft.minecore.config.Config;
import de.pascxl.minecraft.minecore.config.Path;

import java.io.File;

/**
 * Created by Pascal K. on 17.05.2023.
 */
@Getter
public class RedisConfig extends Config {

    @Path("connection.host")
    private String host = "localhost";

    @Path("connection.password")
    private String password = "password";

    @Path("connection.port")
    private int port = 6379;

    public RedisConfig(File file) {
        this.CONFIG_FILE = file;
    }

}
