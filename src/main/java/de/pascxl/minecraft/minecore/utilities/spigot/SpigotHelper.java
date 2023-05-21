package de.pascxl.minecraft.minecore.utilities.spigot;

import com.google.common.reflect.ClassPath;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.event.Event;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Set;
import java.util.function.Consumer;

@UtilityClass
public class SpigotHelper {

    @SneakyThrows
    public void registerCommand(JavaPlugin javaPlugin, Command command) {
        javaPlugin.getServer().getCommandMap().register("core", command);
    }

    @SneakyThrows
    public void registerCommand(JavaPlugin javaPlugin, Command... commands) {
        for (var command : commands) {
            javaPlugin.getServer().getCommandMap().register("core", command);
        }
    }

    public void registerCommand(JavaPlugin javaPlugin, Command command, String fallbackPrefix) {
        javaPlugin.getServer().getCommandMap().register(fallbackPrefix, command);
    }

    public void registerListener(JavaPlugin plugin, Listener listener) {
        Bukkit.getPluginManager().registerEvents(listener, plugin);
    }

    public void registerListeners(JavaPlugin plugin, Listener... listeners) {
        Arrays.stream(listeners).forEach(l -> registerListener(plugin, l));
    }

    public void registerListenersRecursive(JavaPlugin plugin, String packageName, Object... args) {
        try {
            registerListeners(plugin, ClassPath.from(plugin.getClass().getClassLoader()).getTopLevelClassesRecursive(packageName), args);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void registerListeners(JavaPlugin plugin, String packageName, Object... args) {
        try {
            registerListeners(plugin, ClassPath.from(plugin.getClass().getClassLoader()).getTopLevelClasses(packageName), args);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void registerListeners(JavaPlugin plugin, Set<ClassPath.ClassInfo> classInfoSet, Object... args) {
        Class<?>[] argumentTypes = new Class<?>[args.length];

        for (int i = 0; i < args.length; i++) {
            argumentTypes[i] = args[i].getClass();
        }

        int i = 0;
        for (ClassPath.ClassInfo classInfo : classInfoSet) {
            try {
                Object obj = Class.forName(classInfo.getName(), true, plugin.getClass().getClassLoader()).getConstructor(argumentTypes).newInstance(args);

                if (obj instanceof Listener) {
                    Bukkit.getPluginManager().registerEvents((Listener) obj, plugin);
                    i++;
                }
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException |
                     InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        /*if (i > 0) {
            System.out.println("[" + plugin.getClass().getSimpleName() + "] " + i + " listener registered");
        }*/
    }

    public <T extends Event> Listener execute(JavaPlugin plugin, Class<T> event, Consumer<T> listener) {
        Listener finishedListener = new Listener() {
        };

        Bukkit.getServer().getPluginManager().registerEvent(event, finishedListener, EventPriority.NORMAL, (l, use) -> {
            if (event.isInstance(use)) listener.accept((T) use);
        }, plugin, false);
        return finishedListener;
    }

}
