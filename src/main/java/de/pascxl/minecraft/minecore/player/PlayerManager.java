package de.pascxl.minecraft.minecore.player;

import com.google.common.util.concurrent.ListenableFuture;
import de.pascxl.minecraft.minecore.player.nick.NickPlayer;
import de.pascxl.minecraft.minecore.player.permissionuser.PermissionPlayerSerializer;
import de.pascxl.minecraft.minecore.player.user.GlobalPlayer;
import de.pascxl.minecraft.minecore.player.user.GlobalPlayerEventCaller;
import de.pascxl.minecraft.minecore.player.user.GlobalPlayerExecutor;
import de.pascxl.minecraft.minecore.player.permissionuser.PermissionPlayer;

import java.util.List;
import java.util.UUID;

/**
 * Created by Pascal K. on 17.05.2023.
 */
public interface PlayerManager {

    List<NickPlayer> getNickedPlayers();

    NickPlayer getNickPlayer(UUID uniqueId);

    NickPlayer getNickPlayer(String username);

    PermissionPlayerSerializer getPermissionPlayerSerializer();

    PermissionPlayer getPermissionPlayer(UUID uniqueId);

    PermissionPlayer getOrCreatePermissionPlayer(String s, UUID uuid);

    ListenableFuture<PermissionPlayer> createPermissionPlayer(PermissionPlayer permissionUser);

    PermissionPlayer constructPermissionPlayer(String s, UUID uuid);

    ListenableFuture<PermissionPlayer> getPermissionPlayer(String username);

    GlobalPlayerEventCaller<?> getGlobalPlayerEventCaller();

    GlobalPlayerExecutor getGlobalPlayerExecutor();

    <T> List<GlobalPlayer<T>> getOnlinePlayers();

    <T> GlobalPlayer<T> getOnlinePlayer(UUID uniqueID);

    <T> GlobalPlayer<T> getOnlinePlayer(String username);

    <T> List<GlobalPlayer<T>> getGlobalPlayers();

    <T> GlobalPlayer<T> getGlobalPlayer(UUID uniqueId);

    <T> ListenableFuture<GlobalPlayer<T>> getGlobalPlayer(String username);

    void loadAllCloudPlayersFromDatabase();

}
