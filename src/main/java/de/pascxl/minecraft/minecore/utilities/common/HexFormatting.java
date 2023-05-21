package de.pascxl.minecraft.minecore.utilities.common;

import lombok.experimental.UtilityClass;
import net.md_5.bungee.api.ChatColor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Pascal K. on 04.02.2023.
 */
@UtilityClass
public class HexFormatting {

    private final Pattern hexPattern = Pattern.compile("#[a-fA-F0-9]{6}");

    public String formatHex(String var) {
        Matcher matcher = hexPattern.matcher(var);
        while (matcher.find()) {
            String hex = var.substring(matcher.start(), matcher.end());
            var = var.replace(hex, ChatColor.of(hex).toString());
            matcher = hexPattern.matcher(var);
        }
        return ChatColor.translateAlternateColorCodes('&', var);
    }

}
