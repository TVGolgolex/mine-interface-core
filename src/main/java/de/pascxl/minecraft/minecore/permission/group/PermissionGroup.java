package de.pascxl.minecraft.minecore.permission.group;

import de.pascxl.minecraft.minecore.permission.group.permission.Permission;
import de.pascxl.minecraft.minecore.permission.group.styling.PermissionGroupStyling;

import java.util.List;

/**
 * # Date: April 26, 2023
 * # Time. 22:07:30
 * # Name: kuschelstube-core-feat-cloudnet-v4
 */
public interface PermissionGroup {

    String getId();

    PermissionGroupStyling getStyling();

    long getDiscordGroupId();

    long getTeamspeakGroupId();

    String getSorting();

    boolean isDefault();

    boolean isTeam();

    List<Permission> getPermissions();

    boolean isPermitted(Permission permission);

    boolean isPermitted(String key);

    PermissionGroup addPermission(String key, Long until);

    PermissionGroup removePermission(String key);

    PermissionGroup changeActiveState(String key, boolean b);

    void reload();

    void update();

}
