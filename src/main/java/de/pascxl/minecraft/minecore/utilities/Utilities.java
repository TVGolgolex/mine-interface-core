package de.pascxl.minecraft.minecore.utilities;

import de.pascxl.minecraft.minecore.utilities.cloud.CloudUtil;
import de.pascxl.minecraft.minecore.utilities.common.HashUtil;
import de.pascxl.minecraft.minecore.utilities.common.MessageUtil;
import de.pascxl.minecraft.minecore.utilities.common.PageFactory;
import de.pascxl.minecraft.minecore.utilities.common.TimeUtil;
import de.pascxl.minecraft.minecore.utilities.spigot.LocationUtil;
import de.pascxl.minecraft.minecore.utilities.spigot.position.PositionManager;
import de.pascxl.minecraft.minecore.utilities.spigot.sidebar.SidebarManager;

/**
 * Created by Pascal K. on 17.05.2023.
 */
public interface Utilities {

    LocationUtil getLocationUtil();

    HashUtil getHashUtil();

    CloudUtil getCloudUtil();

    MessageUtil getMessageUtil();

    PageFactory<?> getPageFactory(int amount);

    TimeUtil getTimeUtil();


    SidebarManager getSidebarManager();

    PositionManager getPositionManager();

}
