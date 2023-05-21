package de.pascxl.minecraft.minecore.events.bungeecord;

import lombok.AllArgsConstructor;
import lombok.Getter;
import de.pascxl.minecraft.minecore.player.user.GlobalPlayer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Event;

/**
 * Created by Pascal K. on 17.05.2023.
 */
@AllArgsConstructor
@Getter
public class BungeecordGlobalPlayerUpdateEvent extends Event {

    private final GlobalPlayer<ProxiedPlayer> globalPlayer;
    private final String s;

}
