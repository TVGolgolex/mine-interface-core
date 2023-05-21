package de.pascxl.minecraft.minecore.utilities.spigot.sidebar;

import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

/**
 * Created by Pascal K. on 17.05.2023.
 */
public interface SidebarManager {

    HashMap<UUID, Sidebar> sidebars();

    <T extends Sidebar> T sidebar(Player player, Component component, ScoreboardConvertType scoreboardConvertType);

    @Deprecated
    <T extends Sidebar> T sidebar(Player player, String s, ScoreboardConvertType scoreboardConvertType);

    <T extends Sidebar> T ifCached(Player player);

    void updateSidebar(Player player);

    void updateSidebarForAll();

    void handleDisconnect(Player player);

}
