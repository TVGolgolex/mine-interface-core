package de.pascxl.minecraft.minecore.server;

/**
 * Created by Pascal K. on 16.05.2023.
 */
public interface ServerEventCaller {

    void serverUpdateEvent(Server server);

    void serverStartingEvent(Server server);

    void serverReadyEvent(Server server);

    void serverStoppedEvent(Server server);

    void serverChangeToInGame(Server server);

}
