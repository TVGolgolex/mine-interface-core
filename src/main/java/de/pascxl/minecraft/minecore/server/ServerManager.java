package de.pascxl.minecraft.minecore.server;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Optional;

/**
 * Created by Pascal K. on 17.05.2023.
 */
public interface ServerManager {

    Server getCurrentServer();

    ServerInGameCaller getInGameCaller();

    void updateCurrentServer();

    void changeToInGame();

    void changeToInGame(Server server);

    ServerEventCaller getServerEventCaller();

    List<Server> getServers();

    void updateServer(@NotNull Server server, boolean messaging);

    void cacheServer(@NotNull Server server);

    void unCacheServer(@NotNull Server server);

    Optional<Server> getServer(@NotNull String id);

    boolean isReady(@NotNull String id);

    boolean isCached(@NotNull Server server);

    boolean isCached(@NotNull String id);

}
