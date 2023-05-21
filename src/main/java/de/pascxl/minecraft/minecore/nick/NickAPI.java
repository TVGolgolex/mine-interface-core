package de.pascxl.minecraft.minecore.nick;

import com.google.common.util.concurrent.ListenableFuture;
import de.pascxl.minecraft.minecore.nick.profile.PlayerProfile;
import de.pascxl.minecraft.minecore.player.nick.NickInfo;
import de.pascxl.minecraft.minecore.player.nick.NickPlayer;
import de.pascxl.minecraft.minecore.utilities.future.FutureHandler;
import org.bukkit.entity.Player;

import java.util.UUID;

/**
 * Created by Pascal K. on 17.05.2023.
 */
public interface NickAPI {

    static String NICK_PREFIX() {
        return "§8▍ §5Nick §8▎ §7";
    }

    NickConfig getNickConfig();

    PlayerProfile getPlayerProfile(UUID uniqueId);

    NickPlayer nickPlayer(Player player, NickInfo nickInfo, FutureHandler<NickPlayer> then);

    void unNickPlayer(Player player, FutureHandler<NickPlayer> then);

    ListenableFuture<NickInfo> randomNickInfo();

}
