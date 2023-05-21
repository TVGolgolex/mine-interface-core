package de.pascxl.minecraft.minecore.player.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

/**
 * Created by P. Kurz on 27.02.2023 (user: Pascal).
 */
@Getter
@AllArgsConstructor
public class DiscordVerify {

    private final String name;
    private final int id;

    public String full() {
        return name + "#" + id;
    }

}
