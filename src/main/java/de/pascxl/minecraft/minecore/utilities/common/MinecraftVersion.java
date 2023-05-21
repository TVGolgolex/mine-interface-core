package de.pascxl.minecraft.minecore.utilities.common;

/**
 * JavaDoc this file!
 * Created: 15.06.2022
 *
 * @author GolgolexTV (golgolex@golgolex.de)
 */
public enum MinecraftVersion {
    MINECRAFT_1_8(47, "1.8"),
    MINECRAFT_1_9(107, "1.9"),
    MINECRAFT_1_9_1(108, "1.9.1"),
    MINECRAFT_1_9_2(109, "1.9.2"),
    MINECRAFT_1_9_3(110, "1.9.3"),
    MINECRAFT_1_10(210, "1.10"),
    MINECRAFT_1_11(315, "1.11"),
    MINECRAFT_1_11_1(316, "1.11.1"),
    MINECRAFT_1_12(335, "1.12"),
    MINECRAFT_1_12_1(338, "1.12.1"),
    MINECRAFT_1_12_2(340, "1.12.2"),
    MINECRAFT_1_13(393, "1.13"),
    MINECRAFT_1_13_1(401, "1.13.1"),
    MINECRAFT_1_13_2(404, "1.13.2"),
    MINECRAFT_1_14(477, "1.14"),
    MINECRAFT_1_14_1(480, "1.14.1"),
    MINECRAFT_1_14_2(485, "1.14.2"),
    MINECRAFT_1_14_3(490, "1.14.3"),
    MINECRAFT_1_14_4(498, "1.14.4"),
    MINECRAFT_1_15(573, "1.15"),
    MINECRAFT_1_15_1(575, "1.15.1"),
    MINECRAFT_1_15_2(578, "1.15.2"),
    MINECRAFT_1_16(735, "1.16"),
    MINECRAFT_1_16_1(736, "1.16.1"),
    MINECRAFT_1_16_2(751, "1.16.2"),
    MINECRAFT_1_16_3(753, "1.16.3"),
    MINECRAFT_1_16_4(754, "1.16.4"), // Same protocol as 1_16_5
    MINECRAFT_1_16_5(754, "1.16.5"),
    MINECRAFT_1_17(755, "1.17"),
    MINECRAFT_1_17_1(756, "1.17.1"),
    MINECRAFT_1_18(757, "1.18"), // Same protocol as 1_18_1
    MINECRAFT_1_18_1(757, "1.18.1"),
    MINECRAFT_1_18_2(758, "1.18.2"),
    MINECRAFT_1_19(759, "1.19"),
    MINECRAFT_1_19_1(760, "1.19.1"), // Same protocol as 1_19_2
    MINECRAFT_1_19_2(760, "1.19.2"),
    MINECRAFT_1_19_3(761, "1.19.3"),
    MINECRAFT_1_19_4(762, "1.19.4"),
    ;

    private final int protocolId;
    private final String name;

    MinecraftVersion(int protocolId, String name) {
        this.protocolId = protocolId;
        this.name = name;
    }

    public int getProtocolId() {
        return protocolId;
    }

    public String getName() {
        return name;
    }

    public static MinecraftVersion fromProtocolId(int protocolId) {
        for (MinecraftVersion value : values()) {
            if (value.protocolId == protocolId) {
                return value;
            }
        }
        return null;
    }

    public static MinecraftVersion fromName(String name) {
        for (MinecraftVersion value : values()) {
            if (value.name.equals(name)) {
                return value;
            }
        }
        return null;
    }

    public static MinecraftVersion getLatest() {
        return MinecraftVersion.MINECRAFT_1_19_4;
    }
}