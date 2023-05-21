package de.pascxl.minecraft.minecore.utilities.spigot.item.inventory;

import lombok.Getter;
import lombok.experimental.Accessors;
import de.pascxl.minecraft.minecore.utilities.spigot.item.click.ClickableItem;
import de.pascxl.minecraft.minecore.utilities.spigot.item.inventory.utilities.PageSideItem;
import de.pascxl.minecraft.minecore.utilities.spigot.item.stack.ItemFactory;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.List;

/**
 * Created by Pascal K. on 19.12.2022.
 */
@Accessors (fluent = true)
@Getter
public abstract class PagefiedInventory<T> extends CustomInventory {

    private final List<T> elements;
    private final int[] possibleSlots;
    private int currentPage = 1;

    private final PageSideItem nextPageItem;
    private final ClickableItem nextPageItemClickable;
    private final PageSideItem behaviourPageItem;
    private final ClickableItem behaviourPageItemClickable;

    public PagefiedInventory(Player player,
                             int slots,
                             boolean clickable,
                             Component title,
                             int[] possibleSlots,
                             List<T> values,
                             PageSideItem nextPageItem,
                             PageSideItem behaviourPageItem) {
        super(player, slots, clickable, title);
        this.elements = values;
        this.possibleSlots = possibleSlots;
        this.nextPageItem = nextPageItem;
        this.behaviourPageItem = behaviourPageItem;
        if (nextPageItem == null) {
            nextPageItem = new PageSideItem(
                    slots,
                    new ItemFactory(Material.ARROW).displayName(MiniMessage.miniMessage().deserialize("<aqua>Next page")).toItemStack()
            );
        }
        if (behaviourPageItem == null) {
            behaviourPageItem = new PageSideItem(
                    slots,
                    new ItemFactory(Material.ARROW).displayName(MiniMessage.miniMessage().deserialize("<aqua>Behavior page")).toItemStack()
            );
        }
        nextPageItemClickable = ClickableItem.of(nextPageItem.getItemStack(), event -> buildPage(++currentPage));
        behaviourPageItemClickable = ClickableItem.of(behaviourPageItem.getItemStack(), event -> buildPage(--currentPage));

        this.fill();
        this.buildPage(1);
    }

    public void fill() {
    }

    public void onPageChange(PagefiedInventory<T> inventory) {
        if (this.currentPage > 1) {
            setItem(this.behaviourPageItem.getSlot(), this.behaviourPageItemClickable);
        } else {
            removeItem(this.behaviourPageItem.getSlot());
        }

        if (this.elements.size() == this.possibleSlots.length) {
            removeItem(this.nextPageItem.getSlot());
        } else if (this.currentPage < this.maximalPage()) {
            setItem(this.nextPageItem.getSlot(), this.nextPageItemClickable);
        } else {
            removeItem(this.nextPageItem.getSlot());
        }
    }

    public void buildPage(int id) {
        this.currentPage = id;
        this.clear();
        int stepID = 0;
        for (T element : this.elements.subList(this.possibleSlots.length * (this.currentPage - 1),
                Math.min(this.elements.size(), this.possibleSlots.length * (this.currentPage - 1) + this.possibleSlots.length))) {
            setItem(this.possibleSlots[stepID], constructItem(element));
            stepID++;
        }
        onPageChange(this);
    }

    public void clear() {
        for (int slot : this.possibleSlots) {
            this.inventory().clear(slot);
        }
        this.inventoryItems().clear();
    }

    public int maximalPage() {
        return this.elements.size() / this.possibleSlots.length;
    }

    public abstract ClickableItem constructItem(T value);

}
