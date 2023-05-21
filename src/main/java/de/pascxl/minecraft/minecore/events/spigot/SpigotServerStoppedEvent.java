package de.pascxl.minecraft.minecore.events.spigot;

import lombok.AllArgsConstructor;
import lombok.Getter;
import de.pascxl.minecraft.minecore.server.Server;

/**
 * Created by Pascal K. on 16.05.2023.
 */
@Getter
@AllArgsConstructor
public class SpigotServerStoppedEvent extends SpigotEventAsync {

    private final Server server;

}
