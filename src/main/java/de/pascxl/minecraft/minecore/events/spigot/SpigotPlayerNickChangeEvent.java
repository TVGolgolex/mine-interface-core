package de.pascxl.minecraft.minecore.events.spigot;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;

@Getter
@AllArgsConstructor
public final class SpigotPlayerNickChangeEvent extends SpigotEvent implements Cancellable {

    private Player player;
    private NickExecutionType nickExecutionType;

    @Getter
    @Setter
    private boolean cancelled;

    public enum NickExecutionType {

        DO_NICK,
        DO_UN_NICK

    }

}