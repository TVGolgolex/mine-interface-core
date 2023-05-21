package de.pascxl.minecraft.minecore.events.bungeecord;

import lombok.AllArgsConstructor;
import lombok.Getter;
import de.pascxl.minecraft.minecore.permission.group.PermissionGroup;
import de.pascxl.minecraft.minecore.player.permissionplayer.PermissionPlayer;
import net.md_5.bungee.api.plugin.Event;

/**
 * Created by Pascal K. on 17.05.2023.
 */
@Getter
@AllArgsConstructor
public class BungeecordPlayerRankUpdateEvent extends Event {

    private final PermissionPlayer permissionPlayer;
    private final PermissionGroup permissionGroup;

}
