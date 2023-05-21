package de.pascxl.minecraft.minecore.bootstrap;

import java.util.logging.Logger;

/**
 * Created by Pascal K. on 17.05.2023.
 */
public interface IBootstrap<TPlayer,
        TPluginInstance,
        TEvent> {

    TPlayer getPlayer(String key);

    Logger getLogger();

    TPluginInstance getPluginInstance();

    void sendToServer(TPlayer player, String taskId);

    void callEvent(TEvent event);

    void initialize();

    void terminate();

    boolean proxyPlatform();

}
