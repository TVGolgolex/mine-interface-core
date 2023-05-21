package de.pascxl.minecraft.minecore.permission.group.permission;

/**
 * # Date: April 26, 2023
 * # Time. 22:04:58
 * # Name: kuschelstube-core-feat-cloudnet-v4
 */
public interface Permission {

    boolean isPermitted();

    void isPermitted(boolean newState);

    String getKey();

    Long getGot();

    Long getUntil();

}
