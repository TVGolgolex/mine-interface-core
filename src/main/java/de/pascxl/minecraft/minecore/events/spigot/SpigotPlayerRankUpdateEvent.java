package de.pascxl.minecraft.minecore.events.spigot;

import lombok.AllArgsConstructor;
import lombok.Getter;
import de.pascxl.minecraft.minecore.permission.group.PermissionGroup;
import de.pascxl.minecraft.minecore.player.permissionplayer.PermissionPlayer;

/**
 * Created by Pascal K. on 17.05.2023.
 */
@Getter
@AllArgsConstructor
public class SpigotPlayerRankUpdateEvent extends SpigotEventAsync {

    private final PermissionPlayer permissionPlayer;
    private final PermissionGroup permissionGroup;

}
