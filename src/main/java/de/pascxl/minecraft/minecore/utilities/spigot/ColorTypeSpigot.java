package de.pascxl.minecraft.minecore.utilities.spigot;

import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Color;

import java.util.Arrays;

public enum ColorTypeSpigot {

    BOLD("CHAT_BOLD", "§l", 0, null, null, null),
    ITALIC("CHAT_ITALIC", "§o", 0, null, null, null),
    UNDERLINED("CHAT_UNDERLINED", "§n", 0, null, null, null),
    STRIKED_OUT("CHAT_STRIKED_OUT", "§m", 0, null, null, null),
    RANDOM("CHAT_RANDOM", "§k", 0, null, null, null),

    DARK_BLUE("DARK_BLUE", "§1", 4, "6a46053012c68f289abcfb17ab8042d5afba95dcaa99c99c1e0360886d35", Color.NAVY, NamedTextColor.DARK_BLUE),
    DARK_GREEN("DARK_GREEN", "§2", 2, "2c9e601ed9198dbb34c51ddf323929f01a5f958ab11133e3e0407b698393b3f", Color.OLIVE, NamedTextColor.DARK_GREEN),
    DARK_AQUA("DARK_AQUA", "§3", 6, "5218c496dfbdeb4553a6d32b274b9956b7e16a9e4dafc9b33fcf1897b8", Color.TEAL, NamedTextColor.DARK_AQUA),
    DARK_RED("DARK_RED", "§4", 1, "c47237437eef639441b92b217efdc8a72514a9567c6b6b81b553f4ef4ad1cae", Color.MAROON, NamedTextColor.DARK_RED),
    DARK_PURPLE("DARK_PURPLE", "§5", 5, "62d5c732ae5823efebebc12ebad6b559cbb71d6bc7ece53bc4a983adaae43", Color.PURPLE, NamedTextColor.DARK_PURPLE),
    DARK_GRAY("DARK_GRAY", "§8", 8, "fd3cfc239006b257b8b20f85a7bf42026c4ada084c1448d04e0c406ce8a2ea31", Color.GRAY, NamedTextColor.DARK_GRAY),
    RED("RED", "§c", 1, "c47237437eef639441b92b217efdc8a72514a9567c6b6b81b553f4ef4ad1cae", Color.RED, NamedTextColor.RED),
    BLACK("BLACK", "§0", 0, "967a2f218a6e6e38f2b545f6c17733f4ef9bbb288e75402949c052189ee", Color.BLACK, NamedTextColor.BLACK),
    ORANGE("ORANGE", "§6", 14, "13330fbed377c244f487e4bc5682d15af40d3ce4c32ee03fc24a7f952e7d29a9", Color.ORANGE, NamedTextColor.GOLD),
    GRAY("GRAY", "§7", 8, "f9ba7fef6a1a8bd899abae4a5b54cb0ece53badc677c1668bee0a4621a8", Color.SILVER, NamedTextColor.GRAY),
    BLUE("BLUE", "§9", 4, "b8afa1555e9f876481e3c4299ec6e91d22b4075e67e58ef80dcd190ace6519f", Color.BLUE, NamedTextColor.BLUE),
    GREEN("GREEN", "§a", 10, "78d58a7651fedae4c03efebc226c03fd791eb74a132babb974e8d838ac6882", Color.GREEN, NamedTextColor.GREEN),
    AQUA("AQUA", "§b", 6, "5218c496dfbdeb4553a6d32b274b9956b7e16a9e4dafc9b33fcf1897b8", Color.AQUA, NamedTextColor.AQUA),
    PURPLE("PURPLE", "§d", 5, "e4872c8f7a6cef79864769f0cff71ef23f5656567de0001aef36c6b6162ab02d", Color.FUCHSIA, NamedTextColor.LIGHT_PURPLE),
    YELLOW("YELLOW", "§e", 11, "29a030ca2b2c6fe67fe8097d3cd206969fc5c0017c60b6b40990c772a6f0ac0a", Color.YELLOW, NamedTextColor.YELLOW),
    WHITE("WHITE", "§f", 7, "32f3effcb88588cecc75cb852be33a9ac9ed5f9d7e921dbecb5aa559783f", Color.WHITE, NamedTextColor.WHITE),

    ;

    private final String name;
    private final String code;
    private final int subId;
    private final String headId;
    private final Color color;
    private final NamedTextColor namedTextColor;

    ColorTypeSpigot(String name, String code, int subId, String headId, Color color, NamedTextColor namedTextColor) {
        this.name = name;
        this.code = code;
        this.subId = subId;
        this.headId = headId;
        this.color = color;
        this.namedTextColor = namedTextColor;
    }

    public Color getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public int getSubId() {
        return subId;
    }

    public String getCode() {
        return code;
    }

    public String getHeadId() {
        return headId;
    }

    public NamedTextColor getNamedTextColor() {
        return namedTextColor;
    }

    public static ColorTypeSpigot byCode(String s) {
        return Arrays.stream(values()).filter(t -> t.code.equalsIgnoreCase(s)).findFirst().orElse(null);
    }

    public static ColorTypeSpigot byName(String s) {
        return Arrays.stream(values()).filter(t -> t.name.equalsIgnoreCase(s)).findFirst().orElse(null);
    }

}
