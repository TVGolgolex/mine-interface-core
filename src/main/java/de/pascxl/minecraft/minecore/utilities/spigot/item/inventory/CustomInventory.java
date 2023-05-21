package de.pascxl.minecraft.minecore.utilities.spigot.item.inventory;

import de.pascxl.minecraft.minecore.MineCore;
import de.pascxl.minecraft.minecore.utilities.spigot.SpigotHelper;
import lombok.Getter;
import lombok.experimental.Accessors;
import de.pascxl.minecraft.minecore.utilities.spigot.item.click.ClickAction;
import de.pascxl.minecraft.minecore.utilities.spigot.item.click.ClickableItem;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Pascal K. on 19.12.2022.
 */
@Accessors(fluent = true)
@Getter
public class CustomInventory {

    private final Player player;
    private final Inventory inventory;
    private final Map<Integer, ClickableItem> inventoryItems = new HashMap<>();
    private final Listener clickListener;
    private Listener closeListener;

    public CustomInventory(Player player, InventoryType inventoryType, boolean clickable, Component title) {
        this.player = player;
        this.inventory = Bukkit.createInventory(null, inventoryType, title);
        JavaPlugin javaPlugin = MineCore.getInstance().getPlugin();
        this.clickListener = SpigotHelper.execute(javaPlugin, InventoryClickEvent.class, event -> {
            if (event.getView().title().equals(title) &&
                    event.getWhoClicked().getUniqueId().equals(player.getUniqueId())) {
                event.setCancelled(!clickable);
                this.clickIfPreset(event.getSlot(), event);
            }
        });
        this.closeListener = SpigotHelper.execute(javaPlugin, InventoryCloseEvent.class, event -> {
            if (event.getView().title().equals(title) &&
                    event.getPlayer().getUniqueId().equals(player.getUniqueId())) {
                HandlerList.unregisterAll(closeListener);
                HandlerList.unregisterAll(clickListener);
            }
        });
    }

    public CustomInventory(Player player, int slots, boolean clickable, Component title) {
        this.player = player;
        this.inventory = Bukkit.createInventory(null, slots, title);
        JavaPlugin javaPlugin = MineCore.getInstance().getPlugin();
        this.clickListener = SpigotHelper.execute(javaPlugin, InventoryClickEvent.class, event -> {
            if (event.getView().title().equals(title) &&
                    event.getWhoClicked().getUniqueId().equals(player.getUniqueId())) {
                event.setCancelled(!clickable);
                this.clickIfPreset(event.getSlot(), event);
            }
        });
        this.closeListener = SpigotHelper.execute(javaPlugin, InventoryCloseEvent.class, event -> {
            if (event.getView().title().equals(title) &&
                    event.getPlayer().getUniqueId().equals(player.getUniqueId())) {
                HandlerList.unregisterAll(closeListener);
                HandlerList.unregisterAll(clickListener);
            }
        });
    }

    public void setItem(int slot, ItemStack stack, ClickAction clickAction) {
        this.inventoryItems.put(slot, ClickableItem.of(stack, clickAction));
        this.inventory.setItem(slot, stack);
    }

    public void setItem(int slot, ClickableItem clickableItem) {
        this.inventoryItems.put(slot, clickableItem);
        this.inventory.setItem(slot, clickableItem.itemStack());
    }

    private void clickIfPreset(int slot, InventoryClickEvent event) {
        if (this.inventoryItems.containsKey(slot)) {
            this.inventoryItems.get(slot).click(event);
        }
    }

    public void open(Player player) {
        player.openInventory(this.inventory);
    }

    public void removeItem(int slot) {
        this.inventory.clear(slot);
        this.inventoryItems.remove(slot);
    }

    public void clear() {
        this.inventoryItems.clear();
        this.inventory.clear();
    }

}