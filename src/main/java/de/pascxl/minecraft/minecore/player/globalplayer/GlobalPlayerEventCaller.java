package de.pascxl.minecraft.minecore.player.globalplayer;

/**
 * Created by Pascal K. on 17.05.2023.
 */
public interface GlobalPlayerEventCaller<T> {

    void callUpdateEvent(GlobalPlayer<T> globalPlayer, String s);

    void callJoinEvent(GlobalPlayer<T> globalPlayer);

    void callLeftEvent(GlobalPlayer<T> globalPlayer);

}
