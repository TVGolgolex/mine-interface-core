package de.pascxl.minecraft.minecore.bootstrap.pluginimitation;

import de.pascxl.minecraft.minecore.MineCore;
import net.md_5.bungee.api.plugin.Plugin;

/**
 * Created by Pascal K. on 17.05.2023.
 */
public class BungeecordPkuginImitation extends Plugin {

    @Override
    public void onEnable() {
    }

    @Override
    public void onDisable() {
        if (MineCore.getInstance() != null) {
            MineCore.getInstance().shutdown();
        }
    }
}
