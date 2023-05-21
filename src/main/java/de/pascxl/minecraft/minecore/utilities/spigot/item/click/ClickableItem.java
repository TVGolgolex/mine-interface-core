package de.pascxl.minecraft.minecore.utilities.spigot.item.click;

import lombok.Getter;
import lombok.experimental.Accessors;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

/**
 * Created by Pascal K. on 19.12.2022.
 */
@Accessors(fluent = true)
@Getter
public class ClickableItem {

    private final ItemStack itemStack;
    private final ClickAction clickAction;

    private ClickableItem(ItemStack itemStack, ClickAction clickAction) {
        this.itemStack = itemStack;
        this.clickAction = clickAction;
    }

    public static ClickableItem of(ItemStack itemStack) {
        return of(itemStack, null);
    }

    public static ClickableItem of(ItemStack itemStack, ClickAction clickAction) {
        return new ClickableItem(itemStack, clickAction);
    }

    public void click(InventoryClickEvent event) {
        if (this.clickAction == null) return;
        this.clickAction.action(event);
    }

}
