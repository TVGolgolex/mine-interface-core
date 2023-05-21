package de.pascxl.minecraft.minecore.nick;

import lombok.Getter;
import de.pascxl.minecraft.minecore.config.Config;
import de.pascxl.minecraft.minecore.config.Path;

import java.io.File;

/**
 * Created by Pascal K. on 18.05.2023.
 */
@Getter
public class NickConfig extends Config {

    @Path("nickAble")
    private boolean nickAble;
    @Path("nickToggleCommand")
    private boolean nickToggleCommand;

    public NickConfig(File file) {
        this.CONFIG_FILE = file;
    }

}
