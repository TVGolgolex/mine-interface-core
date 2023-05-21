package de.pascxl.minecraft.minecore.utilities.spigot.item.stack;

import com.google.gson.Gson;
import lombok.Getter;
import lombok.experimental.Accessors;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * ItemBuilder - API Class to create a {@link ItemStack} with just one line of Code
 */
@Accessors(fluent = true)
@Getter
public class ItemFactory {

    private ItemStack item;
    private ItemMeta meta;
    private Material material;
    private int customId = -1;
    private int amount = 1;
    private short damage = 0;
    private Map<Enchantment, Integer> enchantments = new HashMap<>();
    private Component displayName;
    private List<Component> lore = new ArrayList<>();
    private List<ItemFlag> flags = new ArrayList<>();

    private Color leatherColor;
    private Color fireWorkColor;
    private boolean unbreakable = false;

    private boolean andSymbol = true;
    private boolean unsafeStackSize = false;

    /**
     * Initalizes the ItemBuilder with {@link Material}
     */
    public ItemFactory(Material material) {
        if (material == null) material = Material.AIR;
        this.item = new ItemStack(material);
        this.material = material;
    }

    /**
     * Initalizes the ItemBuilder with {@link Material} and Amount
     */
    public ItemFactory(Material material, int amount) {
        if (material == null) material = Material.AIR;
        if (amount > material.getMaxStackSize() || amount <= 0) amount = 1;
        this.amount = amount;
        this.item = new ItemStack(material, amount);
        this.material = material;
    }

    /**
     * Initalizes the ItemBuilder with {@link String},
     */
    public static ItemFactory withSkullFullLink(String link) {
        return new ItemFactory(SkullFactory.itemFromUrl(link));
    }

    /**
     * Initalizes the ItemBuilder with {@link String},
     */
    public static ItemFactory withSkullLinkId(String linkId) {
        return new ItemFactory(SkullFactory.itemFromUrl("http://textures.minecraft.net/" + linkId));
    }

    /**
     * Initalizes the ItemBuilder with {@link Material}, Amount and displayName
     */
    public ItemFactory(Material material, int amount, Component displayName) {
        if (material == null) material = Material.AIR;
        this.item = new ItemStack(material, amount);
        this.material = material;
        if (((amount > material.getMaxStackSize()) || (amount <= 0)) && (!unsafeStackSize)) amount = 1;
        this.amount = amount;
        this.displayName = displayName;
    }

    /**
     * Initalizes the ItemBuilder with {@link Material} and displayName
     */
    public ItemFactory(Material material, Component displayName) {
        if (material == null) material = Material.AIR;
        this.item = new ItemStack(material);
        this.material = material;
        this.displayName = displayName;
    }

    /**
     * Initalizes the ItemBuilder with a {@link ItemStack}
     */
    public ItemFactory(ItemStack item) {
        this.item = item;
        if (item.hasItemMeta()) {
            this.meta = item.getItemMeta();
            this.unbreakable = this.meta.isUnbreakable();
            if (this.meta instanceof LeatherArmorMeta) {
                this.leatherColor = ((LeatherArmorMeta) this.meta).getColor();
            }
            if (this.meta instanceof FireworkEffectMeta) {
                this.fireWorkColor = Objects.requireNonNull(((FireworkEffectMeta) this.meta).getEffect()).getColors().get(0);
            }
        }
        this.material = item.getType();
        this.amount = item.getAmount();
        this.damage = item.getDurability();
        this.enchantments = item.getEnchantments();
        if (item.hasItemMeta() && item.getItemMeta().displayName() != null)
            this.displayName = item.getItemMeta().displayName();
        if (item.hasItemMeta() && item.getItemMeta().lore() != null)
            this.lore = item.getItemMeta().lore();
        if (item.hasItemMeta() && !item.getItemMeta().getItemFlags().isEmpty())
            flags.addAll(item.getItemMeta().getItemFlags());
    }

    /**
     * Initalizes the ItemBuilder with a {@link FileConfiguration} ItemStack in Path
     */
    public ItemFactory(FileConfiguration cfg, String path) {
        this(Objects.requireNonNull(cfg.getItemStack(path)));
    }

    /**
     * Initalizes the ItemBuilder with an already existing {@link ItemFactory}
     *
     * @deprecated Use the already initalized {@code ItemBuilder} Instance to improve performance
     */
    @Deprecated
    public ItemFactory(ItemFactory builder) {
        this.item = builder.item;
        this.meta = builder.meta;
        this.material = builder.material;
        this.amount = builder.amount;
        this.leatherColor = builder.leatherColor;
        this.unbreakable = builder.unbreakable;
        this.enchantments = builder.enchantments;
        this.displayName = builder.displayName;
        this.fireWorkColor = builder.fireWorkColor;
        this.lore = builder.lore;
        this.flags = builder.flags;
    }

    /**
     * Sets the Amount of the ItemStack
     *
     * @param amount Amount for the ItemStack
     */
    public ItemFactory amount(int amount) {
        if (((amount > material.getMaxStackSize()) || (amount <= 0)) && (!unsafeStackSize)) amount = 1;
        this.amount = amount;
        return this;
    }

    /**
     * Sets the Damage of the ItemStack
     *
     * @param damage Damage for the ItemStack
     * @deprecated Use {@code ItemBuilder#durability}
     */
    @Deprecated
    public ItemFactory damage(short damage) {
        this.damage = damage;
        return this;
    }

    /**
     * Sets the Durability (Damage) of the ItemStack
     *
     * @param damage Damage for the ItemStack
     */
    public ItemFactory durability(short damage) {
        this.damage = damage;
        return this;
    }

    public ItemFactory customId(int id) {
        this.customId = id;
        return this;
    }

    /**
     * Sets the {@link Material} of the ItemStack
     *
     * @param material Material for the ItemStack
     */
    public ItemFactory material(Material material) {
        this.material = material;
        return this;
    }

    /**
     * Sets the {@link ItemMeta} of the ItemStack
     *
     * @param meta Meta for the ItemStack
     */
    public ItemFactory meta(ItemMeta meta) {
        this.meta = meta;
        return this;
    }

    /**
     * Adds a {@link Enchantment} to the ItemStack
     *
     * @param enchant Enchantment for the ItemStack
     * @param level   Level of the Enchantment
     */
    public ItemFactory enchant(Enchantment enchant, int level) {
        enchantments.put(enchant, level);
        return this;
    }

    /**
     * Adds a list of {@link Enchantment} to the ItemStack
     *
     * @param enchantments Map containing Enchantment and Level for the ItemStack
     */
    public ItemFactory enchant(Map<Enchantment, Integer> enchantments) {
        this.enchantments = enchantments;
        return this;
    }

    /**
     * Sets the displayName of the ItemStack
     *
     * @param displayName displayName for the ItemStack
     */
    public ItemFactory displayName(Component displayName) {
        this.displayName = displayName;
        return this;
    }

    /**
     * Sets the displayName of the ItemStack
     *
     * @param displayName displayName for the ItemStack
     */
    @Deprecated
    public ItemFactory displayName(String displayName) {
        this.displayName = Component.text(displayName);
        return this;
    }

    /**
     * Adds a Line to the Lore of the ItemStack
     *
     * @param line Line of the Lore for the ItemStack
     */
    public ItemFactory lore(Component line) {
        lore.add(line);
        return this;
    }

    /**
     * Sets the Lore of the ItemStack
     *
     * @param lore List containing String as Lines for the ItemStack Lore
     */
    public ItemFactory lore(List<Component> lore) {
        this.lore = lore;
        return this;
    }

    /**
     * Adds one or more Lines to the Lore of the ItemStack
     *
     * @param lines One or more Strings for the ItemStack Lore
     * @deprecated Use {@code ItemBuilder#lore}
     */
    public ItemFactory lores(Component... lines) {
        for (Component line : lines) {
            lore(line);
        }
        return this;
    }

    /**
     * Adds a String at a specified position in the Lore of the ItemStack
     *
     * @param line  Line of the Lore for the ItemStack
     * @param index Position in the Lore for the ItemStack
     */
    public ItemFactory lore(Component line, int index) {
        lore.set(index, line);
        return this;
    }

    /**
     * Adds a {@link ItemFlag} to the ItemStack
     *
     * @param flag ItemFlag for the ItemStack
     */
    public ItemFactory flag(ItemFlag flag) {
        flags.add(flag);
        return this;
    }

    /**
     * Adds more than one {@link ItemFlag} to the ItemStack
     *
     * @param flags List containing all ItemFlags
     */
    public ItemFactory flag(List<ItemFlag> flags) {
        this.flags = flags;
        return this;
    }

    /**
     * Makes or removes the Unbreakable Flag from the ItemStack
     *
     * @param unbreakable If it should be unbreakable
     */
    public ItemFactory unbreakable(boolean unbreakable) {
        this.unbreakable = unbreakable;
        return this;
    }

    /**
     * Makes the ItemStack Glow like it had a Enchantment
     */
    public ItemFactory glow() {
        enchant(material != Material.BOW ? Enchantment.ARROW_INFINITE : Enchantment.LUCK, 10);
        flag(ItemFlag.HIDE_ENCHANTS);
        return this;
    }

    /**
     * Makes the ItemStack Glow like it had a Enchantment
     */
    public ItemFactory glow(boolean mode) {
        if (mode) glow();
        return this;
    }

    public ItemFactory leatherArmorColor(Color color) {
        this.leatherColor = color;
        return this;
    }

    public ItemFactory fireworkChargeColor(Color color) {
        this.fireWorkColor = color;
        return this;
    }

    /**
     * Sets the Skin for the Skull
     *
     * @param user Username of the Skull
     * @deprecated Make it yourself - This Meta destrys the already setted Metas
     */
    @Deprecated
    public ItemFactory owner(String user) {
        if ((material == Material.LEGACY_SKULL_ITEM) || (material == Material.LEGACY_SKULL)) {
            SkullMeta meta = (SkullMeta) this.meta;
            meta.setOwner(user);
            this.meta = meta;
        }
        return this;
    }

    /**
     * Returns the Unsafe Class containing NBT Methods
     */
    public Unsafe unsafe() {
        return new Unsafe(this);
    }

    /**
     * Toggles replacement of the '&' Characters in Strings
     *
     * @deprecated Use {@code ItemBuilder#toggleReplaceAndSymbol}
     */
    @Deprecated
    public ItemFactory replaceAndSymbol() {
        replaceAndSymbol(!andSymbol);
        return this;
    }

    /**
     * Enables / Disables replacement of the '&' Character in Strings
     *
     * @param replace Determinates if it should be replaced or not
     */
    public ItemFactory replaceAndSymbol(boolean replace) {
        andSymbol = replace;
        return this;
    }

    /**
     * Toggles replacement of the '&' Character in Strings
     */
    public ItemFactory toggleReplaceAndSymbol() {
        replaceAndSymbol(!andSymbol);
        return this;
    }

    /**
     * Allows / Disallows Stack Sizes under 1 and above 64
     *
     * @param allow Determinates if it should be allowed or not
     */
    public ItemFactory unsafeStackSize(boolean allow) {
        this.unsafeStackSize = allow;
        return this;
    }

    /**
     * Toggles allowment of stack sizes under 1 and above 64
     */
    public ItemFactory toggleUnsafeStackSize() {
        unsafeStackSize(!unsafeStackSize);
        return this;
    }

    /**
     * Converts the Item to a ConfigStack and writes it to path
     *
     * @param cfg  Configuration File to which it should be writed
     * @param path Path to which the ConfigStack should be writed
     */
    public ItemFactory toConfig(FileConfiguration cfg, String path) {
        cfg.set(path, toItemStack());
        return this;
    }

    /**
     * Converts back the ConfigStack to a ItemBuilder
     *
     * @param cfg  Configuration File from which it should be read
     * @param path Path from which the ConfigStack should be read
     */
    public ItemFactory fromConfig(FileConfiguration cfg, String path) {
        return new ItemFactory(cfg, path);
    }

    /**
     * Converts the Item to a ConfigStack and writes it to path
     *
     * @param cfg     Configuration File to which it should be writed
     * @param path    Path to which the ConfigStack should be writed
     * @param builder Which ItemBuilder should be writed
     */
    public static void toConfig(FileConfiguration cfg, String path, ItemFactory builder) {
        cfg.set(path, builder.toItemStack());
    }

    /**
     * Converts the ItemBuilder to a JsonItemBuilder
     *
     * @return The ItemBuilder as JSON String
     */
    public String toJson() {
        return new Gson().toJson(this);
    }

    /**
     * Converts the ItemBuilder to a JsonItemBuilder
     *
     * @param builder Which ItemBuilder should be converted
     * @return The ItemBuilder as JSON String
     */
    public static String toJson(ItemFactory builder) {
        return new Gson().toJson(builder);
    }

    /**
     * Converts the JsonItemBuilder back to a ItemBuilder
     *
     * @param json Which JsonItemBuilder should be converted
     */
    public static ItemFactory fromJson(String json) {
        return new Gson().fromJson(json, ItemFactory.class);
    }

    /**
     * Applies the currently ItemBuilder to the JSONItemBuilder
     *
     * @param json      Already existing JsonItemBuilder
     * @param overwrite Should the JsonItemBuilder used now
     */
    public ItemFactory applyJson(String json, boolean overwrite) {
        ItemFactory b = new Gson().fromJson(json, ItemFactory.class);
        if (overwrite)
            return b;
        if (b.displayName != null)
            displayName = b.displayName;
        if (b.material != null)
            material = b.material;
        if (b.lore != null)
            lore = b.lore;
        if (b.enchantments != null)
            enchantments = b.enchantments;
        if (b.item != null)
            item = b.item;
        if (b.flags != null)
            flags = b.flags;
        damage = b.damage;
        amount = b.amount;
        return this;
    }

    /**
     * Converts the ItemBuilder to a {@link ItemStack}
     */
    public ItemStack toItemStack() {
        item.setType(material);
        item.setAmount(amount);
        meta = item.getItemMeta();
        if (customId != -1) {
            meta.setCustomModelData(customId);
        }
        if (enchantments.size() > 0) {
            //item.addUnsafeEnchantments(enchantments);
            this.enchantments.forEach((enchantment, integer) -> meta.addEnchant(enchantment, integer, true));
        }
        if (displayName != null) {
            meta.displayName(displayName);
        }
        if (lore.size() > 0) {
            meta.lore(lore);
        }
        if (flags.size() > 0) {
            for (ItemFlag f : flags) {
                meta.addItemFlags(f);
            }
        }
        if (unbreakable) {
            meta.setUnbreakable(true);
        }
        if (leatherColor != null) {
            ((LeatherArmorMeta) meta).setColor(leatherColor);
        }
        if (fireWorkColor != null) {
            FireworkMeta fireworkMeta = (FireworkMeta) meta;
            FireworkEffect.Builder builder = FireworkEffect.builder();
            builder.withColor(this.fireWorkColor);
            builder.flicker(false);
            builder.trail(false);
            builder.withFade(this.fireWorkColor);
            fireworkMeta.addEffects(builder.build());
            item.setItemMeta(fireworkMeta);
        } else {
            item.setItemMeta(meta);
        }
        return item;
    }

    /**
     * Contains NBT Tags Methods
     */
    public static class Unsafe {

        /**
         * Do not access using this Field
         */
        protected final ReflectionUtils utils = new ReflectionUtils();

        /**
         * Do not access using this Field
         */
        protected final ItemFactory builder;

        /**
         * Initalizes the Unsafe Class with a ItemBuilder
         */
        public Unsafe(ItemFactory builder) {
            this.builder = builder;
        }

        /**
         * Sets a NBT Tag {@code String} into the NBT Tag Compound of the Item
         *
         * @param key   The Name on which the NBT Tag should be saved
         * @param value The Value that should be saved
         */
        public Unsafe setString(String key, String value) {
            builder.item = utils.setString(builder.item, key, value);
            return this;
        }

        /**
         * Returns the String that is saved under the key
         */
        public String getString(String key) {
            return utils.getString(builder.item, key);
        }

        /**
         * Sets a NBT Tag {@code Integer} into the NBT Tag Compound of the Item
         *
         * @param key   The Name on which the NBT Tag should be savbed
         * @param value The Value that should be saved
         */
        public Unsafe setInt(String key, int value) {
            builder.item = utils.setInt(builder.item, key, value);
            return this;
        }

        /**
         * Returns the Integer that is saved under the key
         */
        public int getInt(String key) {
            return utils.getInt(builder.item, key);
        }

        /**
         * Sets a NBT Tag {@code Double} into the NBT Tag Compound of the Item
         *
         * @param key   The Name on which the NBT Tag should be savbed
         * @param value The Value that should be saved
         */
        public Unsafe setDouble(String key, double value) {
            builder.item = utils.setDouble(builder.item, key, value);
            return this;
        }

        /**
         * Returns the Double that is saved under the key
         */
        public double getDouble(String key) {
            return utils.getDouble(builder.item, key);
        }

        /**
         * Sets a NBT Tag {@code Boolean} into the NBT Tag Compound of the Item
         *
         * @param key   The Name on which the NBT Tag should be savbed
         * @param value The Value that should be saved
         */
        public Unsafe setBoolean(String key, boolean value) {
            builder.item = utils.setBoolean(builder.item, key, value);
            return this;
        }

        /**
         * Returns the Boolean that is saved under the key
         */
        public boolean getBoolean(String key) {
            return utils.getBoolean(builder.item, key);
        }

        /**
         * Returns a Boolean if the Item contains the NBT Tag named key
         */
        public boolean containsKey(String key) {
            return utils.hasKey(builder.item, key);
        }

        /**
         * Accesses back the ItemBuilder and exists the Unsafe Class
         */
        public ItemFactory builder() {
            return builder;
        }

        /**
         * This Class contains highly sensitive NMS Code that should not be touched unless you want to break the ItemBuilder
         */
        public class ReflectionUtils {

            public String getString(ItemStack item, String key) {
                Object compound = getNBTTagCompound(getItemAsNMSStack(item));
                if (compound == null) {
                    compound = getNewNBTTagCompound();
                }
                try {
                    return (String) compound.getClass().getMethod("getString", String.class).invoke(compound, key);
                } catch (Throwable ex) {
                    ex.printStackTrace();
                }
                return null;
            }

            public ItemStack setString(ItemStack item, String key, String value) {
                Object nmsItem = getItemAsNMSStack(item);
                Object compound = getNBTTagCompound(nmsItem);
                if (compound == null) {
                    compound = getNewNBTTagCompound();
                }
                try {
                    compound.getClass().getMethod("setString", String.class, String.class).invoke(compound, key, value);
                    nmsItem = setNBTTag(compound, nmsItem);
                } catch (Throwable ex) {
                    ex.printStackTrace();
                }
                return getItemAsBukkitStack(nmsItem);
            }

            public int getInt(ItemStack item, String key) {
                Object compound = getNBTTagCompound(getItemAsNMSStack(item));
                if (compound == null) {
                    compound = getNewNBTTagCompound();
                }
                try {
                    return (Integer) compound.getClass().getMethod("getInt", String.class).invoke(compound, key);
                } catch (Throwable ex) {
                    ex.printStackTrace();
                }
                return -1;
            }

            public ItemStack setInt(ItemStack item, String key, int value) {
                Object nmsItem = getItemAsNMSStack(item);
                Object compound = getNBTTagCompound(nmsItem);
                if (compound == null) {
                    compound = getNewNBTTagCompound();
                }
                try {
                    compound.getClass().getMethod("setInt", String.class, Integer.class).invoke(compound, key, value);
                    nmsItem = setNBTTag(compound, nmsItem);
                } catch (Throwable ex) {
                    ex.printStackTrace();
                }
                return getItemAsBukkitStack(nmsItem);
            }

            public double getDouble(ItemStack item, String key) {
                Object compound = getNBTTagCompound(getItemAsNMSStack(item));
                if (compound == null) {
                    compound = getNewNBTTagCompound();
                }
                try {
                    return (Double) compound.getClass().getMethod("getDouble", String.class).invoke(compound, key);
                } catch (Throwable ex) {
                    ex.printStackTrace();
                }
                return Double.NaN;
            }

            public ItemStack setDouble(ItemStack item, String key, double value) {
                Object nmsItem = getItemAsNMSStack(item);
                Object compound = getNBTTagCompound(nmsItem);
                if (compound == null) {
                    compound = getNewNBTTagCompound();
                }
                try {
                    compound.getClass().getMethod("setDouble", String.class, Double.class).invoke(compound, key, value);
                    nmsItem = setNBTTag(compound, nmsItem);
                } catch (Throwable ex) {
                    ex.printStackTrace();
                }
                return getItemAsBukkitStack(nmsItem);
            }

            public boolean getBoolean(ItemStack item, String key) {
                Object compound = getNBTTagCompound(getItemAsNMSStack(item));
                if (compound == null) {
                    compound = getNewNBTTagCompound();
                }
                try {
                    return (Boolean) compound.getClass().getMethod("getBoolean", String.class).invoke(compound, key);
                } catch (Throwable ex) {
                    ex.printStackTrace();
                }
                return false;
            }

            public ItemStack setBoolean(ItemStack item, String key, boolean value) {
                Object nmsItem = getItemAsNMSStack(item);
                Object compound = getNBTTagCompound(nmsItem);
                if (compound == null) {
                    compound = getNewNBTTagCompound();
                }
                try {
                    compound.getClass().getMethod("setBoolean", String.class, Boolean.class).invoke(compound, key, value);
                    nmsItem = setNBTTag(compound, nmsItem);
                } catch (Throwable ex) {
                    ex.printStackTrace();
                }
                return getItemAsBukkitStack(nmsItem);
            }

            public boolean hasKey(ItemStack item, String key) {
                Object compound = getNBTTagCompound(getItemAsNMSStack(item));
                if (compound == null) {
                    compound = getNewNBTTagCompound();
                }
                try {
                    return (Boolean) compound.getClass().getMethod("hasKey", String.class).invoke(compound, key);
                } catch (Throwable e) {
                    e.printStackTrace();
                }
                return false;
            }

            public Object getNewNBTTagCompound() {
                String ver = Bukkit.getServer().getClass().getPackage().getName().split(".")[3];
                try {
                    return Class.forName("net.minecraft.server." + ver + ".NBTTagCompound").newInstance();
                } catch (ClassNotFoundException | IllegalAccessException | InstantiationException ex) {
                    ex.printStackTrace();
                }
                return null;
            }

            public Object setNBTTag(Object tag, Object item) {
                try {
                    item.getClass().getMethod("setTag", item.getClass()).invoke(item, tag);
                    return item;
                } catch (Throwable ex) {
                    ex.printStackTrace();
                }
                return null;
            }

            public Object getNBTTagCompound(Object nmsStack) {
                try {
                    return nmsStack.getClass().getMethod("getTag").invoke(nmsStack);
                } catch (Throwable ex) {
                    ex.printStackTrace();
                }
                return null;
            }

            public Object getItemAsNMSStack(ItemStack item) {
                try {
                    Method m = getCraftItemStackClass().getMethod("asNMSCopy", ItemStack.class);
                    return m.invoke(getCraftItemStackClass(), item);
                } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException ex) {
                    ex.printStackTrace();
                }
                return null;
            }

            public ItemStack getItemAsBukkitStack(Object nmsStack) {
                try {
                    Method m = getCraftItemStackClass().getMethod("asCraftMirror", nmsStack.getClass());
                    return (ItemStack) m.invoke(getCraftItemStackClass(), nmsStack);
                } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException ex) {
                    ex.printStackTrace();
                }
                return null;
            }

            public Class<?> getCraftItemStackClass() {
                String ver = Bukkit.getServer().getClass().getPackage().getName().split(".")[3];
                try {
                    return Class.forName("org.bukkit.craftbukkit." + ver + ".inventory.CraftItemStack");
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
                return null;
            }

        }
    }
}