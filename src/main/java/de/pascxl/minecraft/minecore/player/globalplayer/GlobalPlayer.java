package de.pascxl.minecraft.minecore.player.globalplayer;

import de.pascxl.minecraft.minecore.brand.Brand;
import de.pascxl.minecraft.minecore.language.Language;
import de.pascxl.minecraft.minecore.permission.group.PermissionGroup;
import de.pascxl.minecraft.minecore.player.permissionplayer.PermissionPlayer;
import de.pascxl.minecraft.minecore.utilities.future.FutureHandler;
import org.bson.Document;

import java.util.List;
import java.util.UUID;

/**
 * Created by Pascal K. on 17.05.2023.
 */
public interface GlobalPlayer<TPlayer> {

    UUID getUniqueId();

    String getUsername();

    Document getLocal();

    TPlayer getPlayer();

    Document getProperties();

    String getServer();

    String getBungeecord();

    GlobalPlayerEventCaller<TPlayer> getGlobalPlayerEventCaller();

    GlobalPlayerExecutor getGlobalPlayerExecutor();

    PermissionPlayer getPermissionPlayer();

    PermissionPlayer setPermissionPlayer(PermissionPlayer permissionPlayer);

    Language getLanguage();

    Language setLanguage(Language language);

    Brand getBrand();

    Brand setBrand(Brand brand);

    TPlayer setPlayer(TPlayer player);

    void handleUpdate(Document document);

    <E> void $updateProperty(GlobalPlayerProperty<E> property, E value);

    <E> void updateProperty(GlobalPlayerProperty<E> property, E value);

    <E> void updatePropertyAsync(GlobalPlayerProperty<E> property, E value, FutureHandler<GlobalPlayer<?>> future);

    <E> void updatePropertyAsync(GlobalPlayerProperty<E> property, E value);

    <E> E getProperty(GlobalPlayerProperty<E> property);

    <E> E getNoCachedProperty$(GlobalPlayerProperty<E> property);

    @Deprecated
    void sendMessage(String message);

    void sendMessageAsComponent(String toComponent, boolean miniMessage);

    void sendMessageAsComponent(List<String> toComponent, boolean miniMessage);

    void updateToDatabase();

    void updateToDatabaseAsync();

    //=================================================================================

    void $a();

    void reload();

    //=================================================================================

    void updateConnection(boolean update, boolean online, String server, String bungeecord);

    void connectToServer(String serverName);

    boolean isOnline();

    void addCoins(int coins);

    void removeCoins(int coins);

    void updatePlayTime(long leaveTime, boolean update);

    void updatePlayTimeFromDatabase();

    void setRank(PermissionGroup permissionGroup, long rankEnd);

}