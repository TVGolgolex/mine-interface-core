package de.pascxl.minecraft.minecore.bootstrap.pluginimitation;

import de.pascxl.minecraft.minecore.MineCore;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Pascal K. on 17.05.2023.
 */
public class SpigotPluginsImitation extends JavaPlugin {

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
