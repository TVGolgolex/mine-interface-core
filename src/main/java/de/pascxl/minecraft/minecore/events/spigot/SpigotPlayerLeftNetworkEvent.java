package de.pascxl.minecraft.minecore.events.spigot;

import lombok.AllArgsConstructor;
import lombok.Getter;
import de.pascxl.minecraft.minecore.player.globalplayer.GlobalPlayer;
import org.bukkit.entity.Player;

/**
 * Created by Pascal K. on 17.05.2023.
 */
@Getter
@AllArgsConstructor
public class SpigotPlayerLeftNetworkEvent extends SpigotEventAsync {

    private final GlobalPlayer<Player> globalPlayer;

}
