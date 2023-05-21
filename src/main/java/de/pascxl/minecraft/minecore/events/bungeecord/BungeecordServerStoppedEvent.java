package de.pascxl.minecraft.minecore.events.bungeecord;

import lombok.AllArgsConstructor;
import lombok.Getter;
import de.pascxl.minecraft.minecore.server.Server;
import net.md_5.bungee.api.plugin.Event;

/**
 * Created by Pascal K. on 17.05.2023.
 */
@Getter
@AllArgsConstructor
public class BungeecordServerStoppedEvent extends Event {

    private final Server server;

}
