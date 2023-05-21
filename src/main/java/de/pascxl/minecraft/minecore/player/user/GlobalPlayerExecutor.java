package de.pascxl.minecraft.minecore.player.user;

import net.kyori.adventure.text.Component;

import java.util.List;
import java.util.UUID;

/**
 * Created by Pascal K. on 17.05.2023.
 */
public interface GlobalPlayerExecutor {

    @Deprecated
    void sendMessage(UUID uniqueId, String message);

    void sendMessage(UUID uniqueId, String toComponent, boolean miniMessage);

    void sendMessage(UUID uniqueId, List<String> toComponent, boolean miniMessage);

}
