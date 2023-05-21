package de.pascxl.minecraft.minecore.utilities.spigot.sidebar;

import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scoreboard.Scoreboard;

import java.util.List;
import java.util.function.Consumer;

public interface Sidebar {

    String getKey();

    Player getPlayer();

    Component getDisplayName();

    String getStringDisplayName();

    List<Line> getLines();

    Scoreboard getScoreboard();

    Consumer<Sidebar> update();

    BarState getBarState();

    Sidebar titleAnimation(List<Component> components);

    Sidebar addIdentity(String value);

    Sidebar manipulateUpdateExecutor(Consumer<Sidebar> action);

    Sidebar addLine(Component... content);

    Sidebar addLine(String... content);

    Sidebar updateLine(Component component, int score);

    Sidebar updateLine(String content, int score);

    Sidebar updateDisplayName(Component displayName);

    Sidebar updateDisplayName(String displayName);

    void stopTitleAnimation();

    void titleAnimationTicks(int i);

    void startTitleAnimation(Plugin plugin);

    void generate();

    void sendUpdate();

    record Line(
            Component content,
            String contentAsString,
            int score
    ) {

    }

    enum BarState {

        NOT_CREATED,
        ALREADY_CREATED

    }


}
