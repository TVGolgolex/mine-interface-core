package de.pascxl.minecraft.minecore.nick.profile;

import de.pascxl.minecraft.minecore.permission.group.PermissionGroup;

/**
 * Created by Pascal K. on 17.05.2023.
 */
public interface PlayerProfile {

    String getName();

    PermissionGroup getPermissionGroup();

}
