package de.pascxl.minecraft.minecore.permission.group.styling;

import java.util.UUID;

/**
 * # Date: April 27, 2023
 * # Time. 22:54:55
 * # Name: kuschelstube-core-feat-cloudnet-v4
 */
public interface PermissionGroupStyling {

    //REPLACEMENT #[COLOR]  #[NAME]
    String getPrefix();

    String getSuffix();

    String getHexCode();

    String getAltColor();

    String getFormatted(UUID uniqueId, FormattingVersion version);

    enum FormattingVersion {
        HEX,
        ALT
    }

}
