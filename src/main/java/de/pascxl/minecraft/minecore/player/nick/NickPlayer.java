package de.pascxl.minecraft.minecore.player.nick;

import de.pascxl.minecraft.minecore.player.data.SkinData;
import de.pascxl.minecraft.minecore.permission.group.PermissionGroup;

import java.util.UUID;

/**
 * Created by Pascal K. on 18.05.2023.
 */
public interface NickPlayer {

    UUID getUniqueId();

    String getNickName();

    String getRealName();

    SkinData getSkinData();

    PermissionGroup getNickRank();

}
