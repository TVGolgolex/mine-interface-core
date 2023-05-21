package de.pascxl.minecraft.minecore.config.configs;

import lombok.Getter;
import de.pascxl.minecraft.minecore.config.Comment;
import de.pascxl.minecraft.minecore.config.Config;
import de.pascxl.minecraft.minecore.config.Path;

import java.io.File;

/**
 * Created by Pascal K. on 17.05.2023.
 */
@Getter
public class MongoDBConfig extends Config {

    @Path("connection.host")
    private String host = "localhost";

    @Path("connection.user")
    private String user = "user";

    @Path("connection.password")
    private String password = "password";

    @Path("connection.database")
    private String database = "db";

    @Path("connection.port")
    private int port = 27017;

    @Comment("Name for the database where the user data is stored")
    @Path("databases.user")
    private String userDatabaseName = "user";

    public MongoDBConfig(File file) {
        this.CONFIG_FILE = file;
    }

}
