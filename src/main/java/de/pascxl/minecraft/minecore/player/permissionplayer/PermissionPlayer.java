package de.pascxl.minecraft.minecore.player.permissionplayer;

import de.pascxl.minecraft.minecore.permission.group.PermissionGroup;
import de.pascxl.minecraft.minecore.permission.group.permission.Permission;

import java.util.List;
import java.util.UUID;

/**
 * Created by Pascal K. on 17.05.2023.
 */
public interface PermissionPlayer {

    UUID getUniqueId();

    String getUsername();

    PermissionGroup getGroup();

    long getGroupDuration();

    void setGroup(PermissionGroup permissionGroup, long duration);

    List<Permission> getPermissions();

    boolean isPermitted(Permission permission);

    boolean isPermitted(String key);

    boolean isPermittedIntern(Permission permission);

    boolean isPermittedIntern(String key);

    PermissionPlayer addPermission(String key, Long until);

    PermissionPlayer removePermission(String key);

    PermissionPlayer changeActiveState(String key, boolean b);

    void reload();

    void update();

}
