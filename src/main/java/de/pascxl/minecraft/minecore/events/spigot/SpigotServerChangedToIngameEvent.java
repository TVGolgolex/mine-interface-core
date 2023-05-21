package de.pascxl.minecraft.minecore.events.spigot;

import lombok.AllArgsConstructor;
import lombok.Getter;
import de.pascxl.minecraft.minecore.server.Server;

/**
 * Created by Pascal K. on 17.05.2023.
 */
@Getter
@AllArgsConstructor
public class SpigotServerChangedToIngameEvent extends SpigotEventAsync{

    private final Server server;

}
