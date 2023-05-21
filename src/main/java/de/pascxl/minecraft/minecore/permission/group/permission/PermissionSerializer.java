package de.pascxl.minecraft.minecore.permission.group.permission;

import de.pascxl.minecraft.minecore.database.mongodb.DocumentSerializer;

/**
 * # Date: April 26, 2023
 * # Time. 22:17:51
 * # Name: kuschelstube-core-feat-cloudnet-v4
 */
public interface PermissionSerializer extends DocumentSerializer<Permission> {

    String serializeString(Permission permission);

    Permission deserializeString(String string);

}
